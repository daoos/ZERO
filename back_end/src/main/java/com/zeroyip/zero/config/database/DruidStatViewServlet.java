package com.zeroyip.zero.config.database;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/druid/*", initParams={
        @WebInitParam(name="allow",value=""),                 // IP白名单 (没有配置或者为空，则允许所有访问)
        @WebInitParam(name="deny",value="192.168.16.111"),    // IP黑名单 (存在共同时，deny优先于allow)
        @WebInitParam(name="loginUsername",value="admin"),    // 根据情况配置 (默认为"admin")
        @WebInitParam(name="loginPassword",value="admin"),    // 根据情况配置 (默认为"admin")
        @WebInitParam(name="resetEnable",value="true")        // 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = 2359758657306626394L;
}
