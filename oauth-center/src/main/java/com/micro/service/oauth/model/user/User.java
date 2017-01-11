package com.micro.service.oauth.model.user;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="user")
public class User implements Serializable{

    private static final long serialVersionUID = 6569365774429340632L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="guid",unique=true)
    private String guid ;

    @Column(name="username",unique=true)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="fullname")
    private String fullname;

    @Column(name="nickname")
    private String nickname;

    @Column(name="mobile")
    private String mobile;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="activated")
    private boolean activated;

    @Column(name="activation_key")
    private String activationKey;

    @Column(name="reset_password_key")
    private String resetPasswordKey;

    @Column(name="default_user")
    private boolean defaultUser = false;

    @Column(name="archived")
    private boolean archived = false;

    @Column(name="created")
    private Date created;

    @Column(name="updated")
    private Date updated;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority"), foreignKey = @ForeignKey( name = "none" ))
    private Set<Authority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
    }

    public boolean isDefaultUser() {
        return defaultUser;
    }

    public void setDefaultUser(boolean defaultUser) {
        this.defaultUser = defaultUser;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFullname() {
        return fullname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

}
