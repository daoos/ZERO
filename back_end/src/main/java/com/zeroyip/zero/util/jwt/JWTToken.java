package com.zeroyip.zero.util.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/*
*
* JWTToken可以视为Shiro的用户名和密码的载体
* 由于在前后端分离的无状态情况下，不需RememberMe这类功能，所以简单地实现AuthenticationToken即可
*
* */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
