package com.micro.service.api;

import com.micro.service.member.MemberInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-22 10:53 PM
 */

@Service
public class MemberApiService {

    @Autowired
    private MemberInfoClient memberInfoClient;

    public String getAllMemebers(){
        return  memberInfoClient.getAllMembers();
    }
}
