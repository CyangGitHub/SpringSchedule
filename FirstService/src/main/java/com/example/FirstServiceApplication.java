package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FirstServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(FirstServiceApplication.class).web(true).run(args);

	}
}
