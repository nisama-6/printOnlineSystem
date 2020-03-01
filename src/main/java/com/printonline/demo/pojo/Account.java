package com.printonline.demo.pojo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
/**
 * @ClassName : Account
 * @Description : TODO 登录账户类
 * @Author : niran
 * @Date : 2020/1/25
 **/

@Entity
@Table(name="tb_account")
public class Account {
    /**
     *主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer accountId;

    /**
     * 登录名
     */
    private String username;

    /**
     * 登录密码
     */
    @JsonIgnore
    private String password;

    /**
     * 账号状态
     */
    private Integer status;

    /**
     * 身份
     */
    private String identity;

    /**
     * 用户身份信息
     */
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy="account")
    private UserInfo userInfo;


    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
