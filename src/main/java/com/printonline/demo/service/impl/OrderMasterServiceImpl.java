package com.printonline.demo.service.impl;

import com.printonline.demo.config.OrderStatusEnum;
import com.printonline.demo.pojo.Account;
import com.printonline.demo.pojo.OrderItem;
import com.printonline.demo.pojo.OrderMaster;
import com.printonline.demo.repository.OrderMasterRepository;
import com.printonline.demo.service.LoginService;
import com.printonline.demo.service.OrderMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    LoginService loginService;

    @Override
    public OrderMaster createOrderMaster() {
        return null;
    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) throws ServletException {
        //核算总价格
        accountPrice(orderMaster);

        //设置创建时间
        setDateAndTime(orderMaster);

        //设置订单所属店铺
        setStore(orderMaster);

        //设置订单所属账户
        setOwner(orderMaster);
        orderMaster.setStatus(OrderStatusEnum.NEEDPAY.getValue());
        for(OrderItem orderItem:orderMaster.getOrderItemList()){
            orderItem.setOrderMaster(orderMaster);
        }
        return orderMasterRepository.save(orderMaster);
    }




    @Override
    public OrderMaster findOrderMasterById(Integer orderMasterId) {
        return orderMasterRepository.findOrderMasterByOrderMasterId(orderMasterId);
    }

    @Override
    public List<OrderMaster> findLoginUserOrderMaster() {
        try {
            Account account=loginService.getLoginAccount();
            List<OrderMaster> orderMasterList=orderMasterRepository.getOrderMastersByOwner_AccountId(account.getAccountId());
            return orderMasterList;
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 核算订单的总价格
     * @param orderMaster 需要核算的母订单
     */
    private void accountPrice(OrderMaster orderMaster){
        orderMaster.setTotalPrice(0.0);
        for(OrderItem orderItem:orderMaster.getOrderItemList()){
            if(orderItem.getCurrentPrice()!=null) {
                orderMaster.setTotalPrice(orderMaster.getTotalPrice() + orderItem.getCurrentPrice());
            }else{
                logger.error(orderItem.getOrderItemId()+"子订单项价格为null");
            }
        }
    }

    /**
     * 设置订单的创建时间
     * @param orderMaster 需要设置的订单
     */
    private void setDateAndTime(OrderMaster orderMaster){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        orderMaster.setCreateTime(sdf.format(d));
    }

    /**
     * 设置订单所属店铺
     * @param orderMaster 需要设置的订单
     * @throws NullPointerException 抛出空指针异常
     */
    private void setStore(OrderMaster orderMaster)throws NullPointerException{
      try {
          orderMaster.setStore(orderMaster.getOrderItemList().get(0).getSpecifications().getStore());
      }catch (NullPointerException e){
          logger.error(e.toString());
      }
    }

    /**
     * 设置订单所属账户
     * @param orderMaster 需要设置的订单
     * @throws ServletException
     */
    private void setOwner(OrderMaster orderMaster) throws ServletException {
        Account owner=loginService.getLoginAccount();
        orderMaster.setOwner(owner);
        orderMaster.setOrderNo(String.valueOf(System.currentTimeMillis())+owner.getAccountId());
    }

}
