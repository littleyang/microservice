package com.micro.service.model;

import javax.persistence.*;
import java.io.Serializable;

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
}
