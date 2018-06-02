package com.zeroyip.zero.util.jwt;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*
* 重写继承于官方的BasicHttpAuthenticationFilter的JWTFilter，并重写鉴权方法
* 代码执行流程为preHandle -> isAccessAllowed -> isLoginAttempt -> executeLogin
*
* */
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /*
     *
     * 对跨域提供支持
     *
     * */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // 设置访问源地址
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        // 设置访问源请求头
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 设置访问源请求方法
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,PATCH,DELETE,HEAD,OPTIONS");
        // 跨域时会发送一个option请求，然后给予option请求直接返回正常状态
        if ( httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name()) ) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    /*
     *
     * 此处返回值总是为true，即允许访问
     * 可在Controller中添加subject.isAuthenticated()以判定用户是否登入
     * 若返回值为false，所有请求将被拦截，则用户登录系统后无法看到任何东西
     * 如果某些资源限定用户查看，可在方法上添加@RequiresAuthentication注解(但因为重写了官方方法，这个方法将不可对GET、POST等请求进行鉴权)
     *
     * */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if ( isLoginAttempt(request, response) ) {
            try {
                executeLogin(request, response);
            }
            catch (Exception e) {
                response401(request, response);
            }
        }
        return true;
    }

    /*
    *
    * 判断用户是否想要登入
    * 检测header里面是否包含Authorization字段
    *
    * */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization");
        return authorization != null;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader("Authorization");

        JWTToken token = new JWTToken(authorization);
        // 提交到Realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(token);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /*
     *
     * 将非法请求跳转到 /401
     *
     * */
    private void response401(ServletRequest req, ServletResponse resp) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.sendRedirect("/401");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
