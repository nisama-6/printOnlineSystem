package com.printonline.demo.service;

import com.printonline.demo.pojo.OrderItem;

import java.util.List;

/**
 * @ClassName : OrderItemService
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/7
 **/

public interface OrderItemService {

    /**
     * 创建一个新的OrderItem对象
     * @return 返回创建的OrderItem对象
     */
    OrderItem createOrderItem();

    /**
     * 保存订单
     * @param orderItem
     * @return
     */
    OrderItem saveOrderItem(OrderItem orderItem);

    /**
     * 解析文件
     * @param orderItem
     * @return
     */
    OrderItem parseFile(OrderItem orderItem);

    /**
     * 通过一组id查询OrderItem
     * @param orderItemIds OrderItem的id列表
     * @return
     */
    List<OrderItem> findOrderItemsByIdList(List<Integer> orderItemIds);
}
