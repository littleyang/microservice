package com.micro.service.member.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-09-30 5:16 PM
 */

@FeignClient("member")
public class MemberClient {
}
