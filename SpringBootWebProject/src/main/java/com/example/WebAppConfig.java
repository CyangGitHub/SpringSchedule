package com.example;

import com.example.interceptor.AvoidRepeatSubmissonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by admin on 2016/11/28.
 */
@Component
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AvoidRepeatSubmissonInterceptor())
                .addPathPatterns("/test/token");
    }
}
