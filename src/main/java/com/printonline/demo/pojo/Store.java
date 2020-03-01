package com.printonline.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName : Store
 * @Description : TODO 店铺实体类
 * @Author : niran
 * @Date : 2020/1/25
 **/

@Entity
@Table(name="tb_store")
public class Store {

    /**
     * 店铺表主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer storeId;

    /**
     * 店铺名
     */
    private String storeName;

    /**
     * 店铺地址
     */
    private String storeAddress;

    /**
     * 店铺图片地址
     */
    private String storePicUrl;

    /**
     * 店铺公告
     */
    private String notice;


    /**
     * 店铺联系方式
     */
    private String storePhone;

    /**
     * 店铺邮箱
     */
    private String storeEmail;


    /**
     * 店铺描述
     */
    private String storeDescription;

    /**
     * 店铺状态
     */
    private Integer status;

    /**
     * 店铺评分
     */
    private Double credit;

    /**
     * 评分数量
     */
    private Integer creditNum;

    /**
     * 店铺总销量
     */
    private Long sales;

    /**
     * 店铺是否接单
     */
    private Boolean isReceiveOrder;

    /**
     * 店铺开业时间
     */
    private String openTime;

    /**
     * 店铺关闭时间
     */
    private String closeTime;

    /**
     * 外键，指向指向账户表id，代表持有者id
     */
    @OneToOne
    @JoinColumn(name="ownerId",referencedColumnName="accountId")
    private Account owner;

    @OneToMany(mappedBy = "store")
    @JsonIgnoreProperties(value="store")
    private List<Specifications> specList;


    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePicUrl() {
        return storePicUrl;
    }

    public void setStorePicUrl(String storePicUrl) {
        this.storePicUrl = storePicUrl;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Integer getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(Integer creditNum) {
        this.creditNum = creditNum;
    }

    public Boolean getReceiveOrder() {
        return isReceiveOrder;
    }

    public void setReceiveOrder(Boolean receiveOrder) {
        isReceiveOrder = receiveOrder;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public List<Specifications> getSpecList() {
        return specList;
    }

    public void setSpecList(List<Specifications> specList) {
        this.specList = specList;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }
}
