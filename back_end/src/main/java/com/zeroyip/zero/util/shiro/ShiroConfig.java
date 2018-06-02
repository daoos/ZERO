package com.zeroyip.zero.util.shiro;

import com.zeroyip.zero.util.jwt.JWTFilter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean("securityManager")
    public DefaultWebSecurityManager getManager(MyRealm realm) {
        DefaultWebSecurityManager securityManager  = new DefaultWebSecurityManager();

        // 设置Realm
        securityManager .setRealm(realm);
        // 关闭Shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager .setSubjectDAO(subjectDAO);

        return securityManager ;
    }

    /*
    *
    * ShiroFilterFactoryBean处理拦截资源文件的问题:
    * 单独一个ShiroFilterFactoryBean配置将会报错的，因为在初始化ShiroFilterFactoryBean时需要注入SecurityManager;
    *
    * Filter Chain定义说明:
    * 1.一个URL可以配置多个Filter，使用逗号分隔;
    * 2.当设置多个过滤器时，全部验证通过，才视为通过;
    * 3.部分过滤器可指定参数，如perms，roles;
    *
    * */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 添加自定义过滤器
        Map<String, Filter> filterMap = new HashMap<>();
        // Map<String, Filter> filtersMap = shiroFilterFactoryBean.getFilters();
        filterMap.put("jwt", new JWTFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        // 必须设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setUnauthorizedUrl("/401");
        shiroFilterFactoryBean.setUnauthorizedUrl("/404");

        // 自定义拦截器
        Map<String, String> filterRuleMap = new HashMap<>();
        // Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterRuleMap.put("/**", "jwt");    // 所有请求将通过名为jwt的拦截器
        // 访问401和404页面无法通过自定义拦截器
        filterRuleMap.put("/401", "anon");
        filterRuleMap.put("/404", "anon");
        // shiroFilterFactoryBean.setUnauthorizedUrl("/401");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return shiroFilterFactoryBean;
    }

    /*
     *
     * 添加注解支持
     *
     * */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /*
     *
     * 开启Shiro AOP注解支持，使用代理的方式，需要开启代码支持
     * @param  securityManager 安全管理器
     * @return 授权Advisor
     *
     * */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
