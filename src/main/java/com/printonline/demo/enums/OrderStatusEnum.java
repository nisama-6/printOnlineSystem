package com.printonline.demo.enums;


/**
 * @ClassName : OrderStatusEnum
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/1/27
 **/
public enum OrderStatusEnum implements CodeEnum{

    /* 40 50 60 70 都是支付完毕后的状态 */

    /**
     * 未支付，用户点击取消订单
     */
    CANCELED(0,"已取消"),
    NO_PAY(10,"未支付"),
    PAID(20,"已付款"),
    PROCESSING_ORDER(40,"待取货"),
    ORDER_REFUSED(50,"店主拒绝"),
    ORDER_SUCCESS(60,"订单完结"),
    ORDER_CLOSE(70 , "订单关闭");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
