package com.micro.service.auth.web;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 6:11 PM
 */

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public abstract class WebUtils {


    private static ThreadLocal<String> ipThreadLocal = new ThreadLocal<>();

    //private
    private WebUtils() {
    }


    public static void setIp(String ip) {
        ipThreadLocal.set(ip);
    }

    public static String getIp() {
        return ipThreadLocal.get();
    }


    /**
     * Retrieve client ip address
     *
     * @param request HttpServletRequest
     * @return IP
     */
    public static String retrieveClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnAvailableIp(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static boolean isUnAvailableIp(String ip) {
        return StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip);
    }

}
