package com.zeroyip.zero.util.shiro;

import com.zeroyip.zero.pojo.UserRole;
import com.zeroyip.zero.service.TeamworkService;
import com.zeroyip.zero.util.jwt.JWTToken;
import com.zeroyip.zero.util.jwt.JWTUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
*
* Realm身份校验核心类
*
* */
@Service
public class MyRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

    @Autowired
    private TeamworkService teamworkService;

    /*
     *
     * 必须重写该方法，否则Shiro会报错
     *
     * */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /*
     *
     * 只有当需要检测用户权限的时候才会调用此方法
     *
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 根据userEmail解密token
        String userEmail = JWTUtil.getuserEmail(principals.toString());
        // 使用通过解密获得的userEmail，用于和数据库进行比对
        // 在生产环境中，这一步骤应当使用缓存，否则Shiro将会采取时间间隔限制[2分钟以内不重复执行该方法]
        UserRole user = teamworkService.identification(userEmail);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(user.getMemberRole());
        Set<String> permission = new HashSet<>(Arrays.asList(user.getMemberPermission().split(",")));
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /*
     *
     * 默认使用此方法进行用户名正确与否的验证，否则抛出异常
     * 此方法调用hasRole和hasPermission时方才进行回调
     *
     * 授权:
     * 1.若用户正常退出，缓存自动清空;
     * 2.若用户非正常退出，缓存自动清空;
     * 3.如果修改某用户的权限，而用户当时并未退出系统，则修改的权限无法立即生效
     * (需要手动编程进行实现，并放在service中进行调用)
     * (在权限修改后调用Realm中的方法，Realm已经由Spring管理，所以从Spring中获取Realm实例，调用clearCached方法)
     *
     * Authorization是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等
     *
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        /*
         *
         * 当没有使用缓存时，不断刷新页面，该方法将不断进行;
         * 由于并无必要每次重新设置权限信息，所以我们需要放到缓存中进行管理;
         * 当相关信息存放至缓存中时，doGetAuthorizationInfo方法仅执行一次，缓存过期后会再次执行
         *
         * */
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getuserEmail(token);
        if ( username == null ) {
            throw new AuthenticationException("token已失效");
        }

        UserRole user = teamworkService.identification(username);
        if ( user == null ) {
            throw new AuthenticationException("该用户不存在!");
        }

        if ( !JWTUtil.verify(token, username, user.getUserPsw()) ) {
            throw new AuthenticationException("用户账号或用户密码无效");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
