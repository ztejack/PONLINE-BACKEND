package com.api.ponline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.api.ponline.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ApiPonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPonlineApplication.class, args);
	}

}
