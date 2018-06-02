package com.zeroyip.zero.config.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
        filterName="druidWebStatFilter",
        urlPatterns="/*",
        initParams={
                // 屏蔽静态资源拦截
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),
        })

public class DruidStatFilter extends WebStatFilter {
}
