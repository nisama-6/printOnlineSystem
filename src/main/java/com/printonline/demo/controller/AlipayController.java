package com.printonline.demo.controller;

import com.printonline.demo.AlipayOrder;
import com.printonline.demo.service.AlipayService;
import com.printonline.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName : AlipayController
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/11/16
 **/

@Controller
@RequestMapping("/alipay")
public class AlipayController {

//    @Reference
//    private IOrderPaymentService orderPaymentService;
//    @Reference
//    private IOrderMainService orderMainService;
    @Autowired
    private AlipayService alipayService;


    /**
     * 创建订单
     */

    @ResponseBody
    @GetMapping("/createOrder")
    public String createOrder(AlipayOrder alipayOrder) {
        try {

//            PrintWriter out = response.getWriter();
            // 1、验证订单是否存在

            // 2、创建支付宝订单

            return alipayService.createOrder(alipayOrder);
//            out.println(orderStr);
//            return ResultMap.ok().put("data", orderStr);
        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return ResultMap.error("订单生成失败");
            return "";
        }
    }

    /**
     * 支付异步通知
     * 接收到异步通知并验签通过后，一定要检查通知内容，
     * 包括通知中的app_id、out_trade_no、total_amount是否与请求中的一致，并根据trade_status进行后续业务处理。
     * https://docs.open.alipay.com/194/103296
     */
    @ResponseBody
    @RequestMapping(value = "/notify",method = RequestMethod.POST)
    public String notify(HttpServletRequest request) {
        // 验证签名
        boolean flag = alipayService.rsaCheckV1(request);
        if (flag) {
            String tradeStatus = request.getParameter("trade_status"); // 交易状态
            String outTradeNo = request.getParameter("out_trade_no"); // 商户订单号
            String tradeNo = request.getParameter("trade_no"); // 支付宝订单号
            String total_amount=request.getParameter("total_amount");
            String seller_id=request.getParameter("seller_id");
            String app_id =request.getParameter("app_id");

            /**
             * 还可以从request中获取更多有用的参数，自己尝试
             */
            boolean notify = alipayService.notify(tradeStatus, outTradeNo, tradeNo,total_amount,seller_id,app_id);
            if(notify){
                return "success";
            }
        }
        return "fail";
    }

    @ResponseBody
    @PostMapping("/refund")
    public String  refund(@RequestParam String orderNo, @RequestParam double amount, @RequestParam(required = false) String refundReason) {
//        return alipayService.refund(orderNo, amount, refundReason);
        return alipayService.refund(orderNo, amount, refundReason);
    }

    @RequestMapping(value = "success")
    public String success() {

//        model.addAttribute("trade_no",trade_no);
//        model.addAttribute("out_trade_no",out_trade_no);
//        model.addAttribute("total_amount",total_amount);
        /* 会自动跳转到默认的 classpath:/templates/success.html 页面*/
        return "hello";
    }

    @ResponseBody
    @GetMapping("/orders")
    public Result getAllOrders(){
        return alipayService.getAllOrders();
    }
}