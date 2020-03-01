package com.printonline.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @ClassName : Specifications
 * @Description : TODO 打印规格实体类
 * @Author : niran
 * @Date : 2020/1/27
 **/
@Entity
@Table(name="tb_spec")
public class Specifications {

    /**
     * 打印规格表主键;
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer specId;

    /**
     * 纸张大小
     */
    private String paperSize;

    /**
     * 纸张颜色
     */
    private String paperColor;

    /**
     * 单双面打印
     */
    private String prosAndCons;
    /**
     * 打印一张价格
     */
    private Double  unitPrice;

    /**
     * 所属店铺
     */
    @ManyToOne
    @JoinColumn(name="storeId",referencedColumnName="storeId")
    @JsonIgnore
    private Store store;

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }


    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

    public String getPaperColor() {
        return paperColor;
    }

    public void setPaperColor(String paperColor) {
        this.paperColor = paperColor;
    }

    public String getProsAndCons() {
        return prosAndCons;
    }

    public void setProsAndCons(String prosAndCons) {
        this.prosAndCons = prosAndCons;
    }
}
