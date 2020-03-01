package com.printonline.demo.repository;

import com.printonline.demo.pojo.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;

/**
 * @ClassName : OrderItemRepository
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/7
 **/

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    /**
     * 根据Id查询订单
     * @param OrderItemIdList IdList
     * @return
     */
    List<OrderItem> findOrderItemsByOrderItemIdIn(List<Integer> OrderItemIdList);
}
