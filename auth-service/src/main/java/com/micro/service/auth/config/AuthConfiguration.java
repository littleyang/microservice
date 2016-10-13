package com.micro.service.auth.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 4:22 PM
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource("classpath:/spring/context.xml")
public class AuthConfiguration {

}
