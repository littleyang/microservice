package com.micro.service.api;

import com.micro.service.utils.MainUtils;
import org.junit.Test;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-22 11:25 AM
 */

public class ApiTestBase {

    @Test
    public void testCommonUtilsTest(){
        MainUtils utils = new MainUtils();
        System.out.println(utils.sayHello("my world!!!!"));
    }
}
