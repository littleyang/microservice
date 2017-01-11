package com.micro.service.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-09-30 4:29 PM
 */

@Entity
@Table(name="user")
public class User implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    @Column(name="account",nullable = false,length = 64)
    private String account;

    @Column(name="fullname",nullable = false,length = 128)
    private String fullname;

    @Column(name="nickname")
    private String nickname;

    @Column(name="mobile")
    private String mobile;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="archived")
    private boolean archived = false;

    @Column(name="created")
    private Date created;

    @Column(name="updated")
    private Date updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


}
