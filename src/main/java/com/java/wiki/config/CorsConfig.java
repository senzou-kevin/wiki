package com.java.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")//映射的请求地址
                .allowedOriginPatterns("*")//
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedMethods(CorsConfiguration.ALL)//表示get和post请求都支持
                .allowCredentials(true)//允许带上凭证比如cookie信息
                .maxAge(3600);//1小时内不需要再预检（发OPTIONS请求）

    }
}
