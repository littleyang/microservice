//package com.micro.service.config;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.List;
//
///**
// * @description:
// * @author: yang.zhou
// * @version: 1.0.0
// * @since: 2016-11-19 10:56 PM
// */
//
//@Configuration
//@EnableWebMvc
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false).
//                favorParameter(true).
//                parameterName("mediaType").
//                ignoreAcceptHeader(true).
//                useJaf(false).
//                defaultContentType(MediaType.APPLICATION_JSON).
//                mediaType("xml", MediaType.APPLICATION_XML).
//                mediaType("json", MediaType.APPLICATION_JSON);
//    }
//
//
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(mappingJackson2HttpMessageConverter());
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
//        return converter;
//    }
//}
