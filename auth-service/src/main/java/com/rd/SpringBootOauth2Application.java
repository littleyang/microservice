package com.rd;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootOauth2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootOauth2Application.class).web(true).run(args);
    }
}
