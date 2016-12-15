package com.micro.service.promo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PromoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromoServiceApplication.class, args);
	}
}
