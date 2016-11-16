package com.micro.service.compute.member;

import com.micro.service.member.MemberInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-11-16 11:00 PM
 */

@Service
public class MemberInfoService {

    @Autowired
    private MemberInfoClient memberInfoClient;


    public String getAllMembers(){
        return memberInfoClient.getAllMembers();
    }

}
