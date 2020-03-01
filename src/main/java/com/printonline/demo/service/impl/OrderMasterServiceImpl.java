package com.printonline.demo.service.impl;

import com.printonline.demo.pojo.OrderItem;
import com.printonline.demo.pojo.OrderMaster;
import com.printonline.demo.repository.OrderMasterRepository;
import com.printonline.demo.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : OrderMasterServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/15
 **/

@Service
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderMaster createOrderMaster() {
        return null;
    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) {
        //核算总价格
        accountPrice(orderMaster);

        //设置创建时间
        setDateAndTime(orderMaster);

        orderMaster.setStatus(101);

        for(OrderItem orderItem:orderMaster.getOrderItemList()){
            orderItem.setOrderMaster(orderMaster);
        }
        return orderMasterRepository.save(orderMaster);
    }


    /**
     * 核算订单的总价格
     * @param orderMaster 需要核算的母订单
     */
    private void accountPrice(OrderMaster orderMaster){
        orderMaster.setTotalPrice(0.0);
        for(OrderItem orderItem:orderMaster.getOrderItemList()){
            orderMaster.setTotalPrice(orderMaster.getTotalPrice()+orderItem.getCurrentPrice());
        }
    }

    /**
     * 设置订单的创建时间
     * @param orderMaster
     */
    private void setDateAndTime(OrderMaster orderMaster){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderMaster.setCreateTime(sdf.format(d));
    }
}
