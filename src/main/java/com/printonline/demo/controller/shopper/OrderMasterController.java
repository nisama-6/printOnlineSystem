package com.printonline.demo.controller.shopper;

import com.printonline.demo.pojo.OrderItem;
import com.printonline.demo.pojo.OrderMaster;
import com.printonline.demo.service.OrderItemService;
import com.printonline.demo.service.OrderMasterService;
import com.printonline.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : OrderMasterController
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/15
 **/

@RestController
@RequestMapping("/shopper")
public class OrderMasterController {
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderMasterService orderMasterService;

    @RequestMapping(value = "/orderMaster", method = RequestMethod.POST)
    public Result createNewOrderMaster(@RequestBody Map<String,List> data) throws ServletException {
        List orderItemIdList=data.get("orderItemIdList");
        OrderMaster orderMaster=new OrderMaster();
        List<OrderItem> orderItemList=orderItemService.findOrderItemsByIdList(orderItemIdList);

        orderMaster.setOrderItemList(orderItemList);
        orderMasterService.save(orderMaster);
        return new Result();
    }
}
