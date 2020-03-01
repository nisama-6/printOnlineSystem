package com.printonline.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @ClassName : UserInfo
 * @Description : TODO 用户信息类
 * @Author : niran
 * @Date : 2020/1/25
 **/

@Entity
@Table(name="tb_userInfo")
public class UserInfo {

    /**
     * 用户信息表主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;


    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户联系方式
     */
    private String phone;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像地址
     */
    private String advUrl;

    /**
     * 外键，指向账户表主键
     */
    @OneToOne()
    @JoinColumn(name="accountId",referencedColumnName="accountId")
    @JsonIgnore
    private Account account;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAdvUrl() {
        return advUrl;
    }

    public void setAdvUrl(String advUrl) {
        this.advUrl = advUrl;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
