package com.fatina.exchangeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ExchangeprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeprojectApplication.class, args);
	}

}
