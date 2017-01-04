package com.example;

import com.example.interceptor.AvoidRepeatSubmissonInterceptor;
import com.example.module.Myfilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Configuration
public class SpringBootWebProjectApplication extends WebMvcConfigurerAdapter{


	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new Myfilter());
		filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }



	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebProjectApplication.class, args);
	}


}
