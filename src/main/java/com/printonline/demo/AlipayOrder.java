package com.printonline.demo;

/**
 * @ClassName : AlipayOrder
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/11/18
 **/

public class AlipayOrder {
    private String subject;
    private String orderNo;
    private String amount;
    private String body;
    private String status;
    private String tradeNo;//支付宝交易号

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}
