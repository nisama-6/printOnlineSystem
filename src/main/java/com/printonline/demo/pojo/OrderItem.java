package com.printonline.demo.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName : OrderItem
 * @Description : TODO 子订单实体类
 * @Author : niran
 * @Date : 2020/1/27
 **/
@Entity
@Table(name="tb_orderItem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer orderItemId;

    /**
     * 当前子订单的价格
     */
    private Double currentPrice;

    /**
     * 子订单创建时间
     */
    private Date createTime;

    /**
     * 打印份数
     */
    private Integer printCount;

    /**
     * 父订单
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderMasterId",referencedColumnName="orderMasterId")
    private OrderMaster orderMaster;


    /**
     * 上传的文件
     */
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy="orderItem",fetch = FetchType.LAZY)
    private UploadFile uploadFile;

    /**
     * 打印规格
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="specId",referencedColumnName="specId")
    private Specifications specifications;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public OrderMaster getOrderMaster() {
        return orderMaster;
    }

    public void setOrderMaster(OrderMaster orderMaster) {
        this.orderMaster = orderMaster;
    }

    public UploadFile getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(UploadFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }
}
