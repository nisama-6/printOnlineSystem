package com.printonline.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @ClassName : Comment
 * @Description : TODO 评价表实体类
 * @Author : niran
 * @Date : 2020/1/25
 **/

@Entity
@Table(name="tb_comment")
public class Comment {

    /**
     * 评价表主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer comId;

    /**
     * 评价的订单
     */
    @OneToOne
    @JoinColumn(name="orderMasterId",referencedColumnName="orderMasterId")
    @JsonIgnoreProperties(value = "store")
    private OrderMaster orderMaster;


    /**
     * 评价分数
     */
    private Double score;

    /**
     *评论内容
     */
    private String content;
    /**
     * 评论日期
     */
    private String commentDate;



    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public OrderMaster getOrderMaster() {
        return orderMaster;
    }

    public void setOrderMaster(OrderMaster orderMaster) {
        this.orderMaster = orderMaster;
    }
}
