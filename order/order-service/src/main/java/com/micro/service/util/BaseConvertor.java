package com.micro.service.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 对象转化工具类
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-12-09 2:11 PM
 */

public class BaseConvertor {

    public static <K> K convert(Object source,Class<K> clazz,String... properties) {
        if(source==null) return null;
        K target=(K) BeanUtils.instantiate(clazz);
        BeanUtils.copyProperties(source, target,properties);
        return target;
    }

    public static <K> List<K> convertList(List<?> sources, Class<K> clazz, String... properties) {
        if(sources==null) return null;
        List<K> results=new ArrayList<K>();
        for(Object source:sources){
            K target=(K)BeanUtils.instantiate(clazz);
            BeanUtils.copyProperties(source, target,properties);
            results.add(target);
        }
        return results;
    }

}
