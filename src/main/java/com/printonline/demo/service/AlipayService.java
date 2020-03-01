package com.printonline.demo.service;

import com.alipay.api.AlipayApiException;
import com.printonline.demo.AlipayOrder;
import com.printonline.demo.tools.Result;


import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : AlipayService
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/11/16
 **/

public interface AlipayService {

    /**
     * @Description: 创建支付宝订单
     * @param orderNo: 订单编号
     * @param amount: 实际支付金额
     * @param body: 订单描述
     * @Author:
     * @Date: 2019/8/1
     * @return
     */
    String createOrder(AlipayOrder alipayOrder) throws AlipayApiException;



    String createAppOrder(String orderNo, double amount, String body) throws AlipayApiException;

    /**
     * @Description:
     * @param tradeStatus: 支付宝交易状态
     * @param orderNo: 订单编号
     * @param tradeNo: 支付宝订单号
     * @Author:
     * @Date: 2019/8/1
     * @return
     */
    boolean notify(String tradeStatus, String orderNo, String tradeNo, String total_amount, String seller_id, String app_id);

    /**
     * @Description: 校验签名
     * @param request
     * @Author:
     * @Date: 2019/8/1
     * @return
     */
    boolean rsaCheckV1(HttpServletRequest request);

    /**
     * @Description: 退款
     * @param orderNo: 订单编号
     * @param amount: 实际支付金额
     * @param refundReason: 退款原因
     * @Author: XCK
     * @Date: 2019/8/6
     * @return
     */
    String refund(String orderNo, double amount, String refundReason);


    Result getAllOrders();
}