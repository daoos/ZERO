package com.zeroyip.zero;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.lang.reflect.Array;

//@ServletComponentScan
@SpringBootApplication
@MapperScan("com.zeroyip.zero.mapper")
public class ZeroApplication {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");                      // 设置访问源地址
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);    // 设置访问源请求头
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);    // 设置访问源请求方法
        return corsConfiguration;
    }

    /*
     *
     * 配置跨域过滤器
     * @return
     *
     * */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    public static void main(String[] args) {
        SpringApplication.run(ZeroApplication.class, args);
    }
}
