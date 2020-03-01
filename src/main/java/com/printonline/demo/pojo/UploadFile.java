package com.printonline.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @ClassName : File
 * @Description : TODO 上传文件实体类
 * @Author : niran
 * @Date : 2020/1/27
 **/
@Entity
@Table(name="tb_uploadFile")
public class UploadFile {
    /**
     * file表主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件页数
     */
    private Integer pageNum;

    /**
     * 文件描述
     */
    private String description;

    /**
     * 文件路径
     */
    private String fileUrl;

    @OneToOne
    @JoinColumn(name="orderItemId",referencedColumnName="orderItemId")
    @JsonIgnore
    private OrderItem orderItem;


    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
