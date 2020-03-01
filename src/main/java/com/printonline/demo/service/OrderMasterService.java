package com.printonline.demo.service;

import com.printonline.demo.pojo.OrderMaster;

/**
 * @ClassName : OrderMasterService
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/15
 **/

public interface OrderMasterService {

    /**
     * 创建新的订单
     * @return 返回创建的订单
     */
    OrderMaster createOrderMaster();

    /**
     * 保存OrderMaster对象
     * @param orderMaster  需要保存的OrderMaster对象
     * @return 返回保存后的OrderMaster
     */
    OrderMaster save(OrderMaster orderMaster);
}
