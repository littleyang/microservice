package com.micro.service.oauth.model.dto;

import com.micro.service.oauth.model.user.User;
import com.micro.service.oauth.utils.DateUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-18 11:55 AM
 */

public class UserJsonDto {

    private String guid;
    private String username;
    private String mobile;
    private String fullname;
    private String nickname;
    private String phone;
    private String email;
    private String created;
    private String updated;
    private boolean archived;

    public UserJsonDto() {
    }

    public UserJsonDto(User user) {
        this.guid = user.getGuid();
        this.archived = user.isArchived();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.mobile = user.getMobile();
        this.fullname = user.getFullname();
        this.nickname = user.getNickname();
        this.created = DateUtils.toDateTime(user.getCreated());
        this.updated = DateUtils.toDateTime(user.getUpdated());

    }

    public static List<UserJsonDto> UserListJsonDto(List<User> users){
        List<UserJsonDto> results = new ArrayList<UserJsonDto>(users.size());
        users.forEach(user -> {
            UserJsonDto dto = new UserJsonDto(user);
            results.add(dto);
        });
        return results;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {

        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
