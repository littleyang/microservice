package com.micro.service;

import com.micro.service.filter.AccessFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableZuulProxy
@Controller
public class RouteServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RouteServiceApplication.class).web(true).run(args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
