package com.micro.service.coupon.api;

import com.micro.service.coupon.dto.CouponDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-23 2:59 PM
 */

@FeignClient("coupons")
@Component
public interface CouponFacadeClient {

    public static final String GET_COUPON_BY_ID_REST = "/coupon/{id}";

    public static final String GET_ALL_COUPON_REST = "/coupon/all";

    @HystrixCommand(ignoreExceptions=Exception.class)
    @RequestMapping(method = RequestMethod.GET,value = GET_COUPON_BY_ID_REST)
    @HystrixProperty(name = "hystrix.command.default.execution.timeout.enabled", value = "false")
    public CouponDto getCouponById(@PathVariable("id") int id);

    @HystrixCommand(ignoreExceptions=Exception.class)
    @RequestMapping(method = RequestMethod.GET,value = GET_ALL_COUPON_REST)
    @HystrixProperty(name = "hystrix.command.default.execution.timeout.enabled", value = "false")
    public List<CouponDto> getAllCoupons();

}
