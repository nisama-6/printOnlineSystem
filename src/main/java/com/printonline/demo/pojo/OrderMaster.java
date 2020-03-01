package com.printonline.demo.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @ClassName : Order
 * @Description : TODO 总订单实体类
 * @Author : niran
 * @Date : 2020/1/27
 **/
@Entity
@Table(name="tb_orderMaster")
public class OrderMaster {

    /**
     * 订单表主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer orderMasterId;

    /**
     *订单号
     */
    private String orderNo;

    /**
     * 订单总金额
     */
    private Double totalPrice;

    /**
     *订单状态
     */
    private Integer status;
    /**
     * 持有者
     */
    @OneToOne
    @JoinColumn(name="ownerId",referencedColumnName="accountId")
    private Account owner;


    /**
     * 订单对应的店铺
     */
    @OneToOne
    @JoinColumn(name="storeId",referencedColumnName="storeId")
    private Store store;
    /**
     * 订单创建时间
     */
    private String createTime;

    /**
     * 订单更新时间
     */
    private String updateTime;

    /**
     * 订单支付时间
     */
    private String paymentTime;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderMaster")
    private List<OrderItem> orderItemList;

    public Integer getOrderMasterId() {
        return orderMasterId;
    }

    public void setOrderMasterId(Integer orderMasterId) {
        this.orderMasterId = orderMasterId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
