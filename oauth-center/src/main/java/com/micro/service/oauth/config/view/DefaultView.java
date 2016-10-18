package com.micro.service.oauth.config.view;

import com.micro.service.oauth.Interceptor.AccessTokenVerifyInterceptor;
import com.micro.service.oauth.filter.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-15 10:04 AM
 */

@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {

    @Autowired
    private AccessTokenVerifyInterceptor accessTokenVerifyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessTokenVerifyInterceptor).addPathPatterns("/api/**");
        super.addInterceptors(registry);
    }

    @Bean
    public FilterRegistrationBean getDemoFilter(){
        RequestFilter filter = new RequestFilter();
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        List<String> urlPatterns=new ArrayList<String>();
        urlPatterns.add("/*");//拦截路径，可以添加多个
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }

}