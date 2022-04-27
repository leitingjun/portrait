package com.leitingjun.portrait.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/xx").allowCredentials(true);
        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
