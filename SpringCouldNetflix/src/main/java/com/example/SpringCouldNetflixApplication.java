package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//启动一个服务注册中心给其他应用会话
public class SpringCouldNetflixApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringCouldNetflixApplication.class).web(true).run(args);
	}
}
