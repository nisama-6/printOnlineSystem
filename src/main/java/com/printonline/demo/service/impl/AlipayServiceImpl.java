package com.printonline.demo.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.internal.util.StringUtils;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.printonline.demo.AlipayOrder;
import com.printonline.demo.AlipayConfig;
import com.printonline.demo.OrderMap;
import com.printonline.demo.service.AlipayService;
import com.printonline.demo.tools.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : AlipayServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/11/16
 **/

@Service
public class AlipayServiceImpl implements AlipayService {
    private final Logger logger = LoggerFactory.getLogger(AlipayServiceImpl.class);

    @Autowired
    private AlipayConfig alipayConfig;
    @Autowired
    private AlipayClient alipayClient;

    @Override
    public String createOrder(AlipayOrder alipayOrder) throws AlipayApiException, AlipayApiException {
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradePagePayRequest alipayTradePagePayRequest=new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setNotifyUrl(alipayConfig.getNotifyUrl());
        alipayTradePagePayRequest.setReturnUrl(alipayConfig.getReturnUrl());
        alipayTradePagePayRequest.setBizContent("{\"out_trade_no\":\""+ alipayOrder.getOrderNo() +"\","
                + "\"total_amount\":\""+ alipayOrder.getAmount() +"\","
                + "\"subject\":\""+ alipayOrder.getSubject() +"\","
                + "\"body\":\""+ alipayOrder.getBody() +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        alipayOrder.setStatus("WAIT_BUYER_PAY");
        OrderMap.alipayOrderMap.put(alipayOrder.getOrderNo(),alipayOrder);

        AlipayTradePagePayResponse alipayResponse=alipayClient.pageExecute(alipayTradePagePayRequest);
//

        return alipayResponse.getBody();
    }

    @Override
    public String createAppOrder(String orderNo, double amount, String body) throws AlipayApiException, AlipayApiException {
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setSubject(body);
        model.setOutTradeNo(orderNo);
        model.setTotalAmount(String.valueOf(amount));
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        model.setPassbackParams("公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数");

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
        ali_request.setBizModel(model);
        ali_request.setNotifyUrl(alipayConfig.getNotifyUrl());// 回调地址
        AlipayTradeAppPayResponse ali_response = alipayClient.sdkExecute(ali_request);
//        就是orderString 可以直接给客户端请求，无需再做处理。
        return ali_response.getBody();

    }

    @Override
    public boolean notify(String tradeStatus, String orderNo, String tradeNo,String total_amount,String seller_id,String app_id) {
        // 支付成功，根据业务逻辑修改相应数据的状态
        //             boolean state = orderPaymentService.updatePaymentState(orderNo, tradeNo);


        AlipayOrder alipayOrder = OrderMap.alipayOrderMap.get(orderNo);

        if (alipayOrder == null)
            return false;
        if (!alipayOrder.getAmount().equals(total_amount))
            return false;
        if (!seller_id.equals(alipayConfig.getSellerid()))
            return false;
        if (!app_id.equals(alipayConfig.getAppid()))
            return false;

        alipayOrder.setStatus(tradeStatus);
        alipayOrder.setTradeNo(tradeNo);

        return "TRADE_FINISHED".equals(tradeStatus) || "TRADE_SUCCESS".equals(tradeStatus);
    }

    @Override
    public boolean rsaCheckV1(HttpServletRequest request){
        try {
            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                String[] values = requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                params.put(name, valueStr);
            }

            return AlipaySignature.rsaCheckV1(params, alipayConfig.getAlipayPublicKey(), alipayConfig.getCharset(), alipayConfig.getSignType());
        } catch (AlipayApiException e) {
            logger.debug("verify sigin error, exception is:{}", e);
            return false;
        }
    }

    @Override
    public String refund(String orderNo, double amount, String refundReason) {
        if(StringUtils.isEmpty(orderNo)){
            return "订单编号不能为空";
        }
        if(amount <= 0){
            return "退款金额必须大于0";
        }

        AlipayTradeRefundModel model=new AlipayTradeRefundModel();
        // 商户订单号
        model.setOutTradeNo(orderNo);
        // 退款金额
        model.setRefundAmount(String.valueOf(amount));
        // 退款原因
        model.setRefundReason(refundReason);
        // 退款订单号(同一个订单可以分多次部分退款，当分多次时必传)
        // model.setOutRequestNo(UUID.randomUUID().toString());
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        alipayRequest.setBizModel(model);
        AlipayTradeRefundResponse alipayResponse = null;
        try {
            alipayResponse = alipayClient.execute(alipayRequest);
        } catch (AlipayApiException e) {
            logger.error("订单退款失败，异常原因:{}", e);
        }
        if(alipayResponse != null){
            String code = alipayResponse.getCode();
            String subCode = alipayResponse.getSubCode();
            String subMsg = alipayResponse.getSubMsg();
            if("10000".equals(code)
                    && StringUtils.isEmpty(subCode)
                    && StringUtils.isEmpty(subMsg)){
                // 表示退款申请接受成功，结果通过退款查询接口查询
                // 修改用户订单状态为退款
                AlipayOrder alipayOrder=OrderMap.alipayOrderMap.get(orderNo);
                alipayOrder.setStatus("TRADE_CLOSED");
                return "订单退款成功";
            }
            return subCode + ":" + subMsg;
        }
        return "订单退款失败";
    }

    @Override
    public Result getAllOrders() {
        return new Result(OrderMap.alipayOrderMap.values());
    }
}