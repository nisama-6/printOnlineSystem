package com.printonline.demo.controller.shopper;

import com.printonline.demo.pojo.OrderItem;
import com.printonline.demo.service.OrderItemService;
import com.printonline.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * @ClassName : OrderItemController
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/7
 **/
@RestController
@RequestMapping("/shopper")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = "/orderItem", method = RequestMethod.PUT)
    public Result createNewOrderItem() throws ServletException {
        OrderItem orderItem = orderItemService.createOrderItem();
        if (orderItem == null) {
            throw new ServletException("创建订单失败!");
        }
        return new Result(orderItem);
    }

    @RequestMapping(value = "/orderItem", method = RequestMethod.POST)
    public Result saveOrderItem(@RequestBody OrderItem orderItem) throws ServletException {
        orderItem = orderItemService.saveOrderItem(orderItem);
        if (orderItem == null) {
            throw new ServletException("保存订单失败!");
        }
        return new Result(orderItem);
    }

}
