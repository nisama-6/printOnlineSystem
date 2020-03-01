package com.printonline.demo.service.impl;

import com.printonline.demo.pojo.OrderItem;
import com.printonline.demo.pojo.UploadFile;
import com.printonline.demo.repository.OrderItemRepository;
import com.printonline.demo.repository.UploadFileRepository;
import com.printonline.demo.service.OrderItemService;
import com.printonline.demo.tools.fileParse.DocParse;
import com.printonline.demo.tools.fileParse.FileParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : OrderItemServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/7
 **/

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private UploadFileRepository uploadFileRepository;

    @Override
    public OrderItem createOrderItem() {
        OrderItem orderItem=new OrderItem();
        orderItem=orderItemRepository.save(orderItem);
        return orderItem;
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        orderItem.setCurrentPrice(2.3);
        UploadFile uploadFile=orderItem.getUploadFile();
        uploadFile.setOrderItem(orderItem);
        orderItem=orderItemRepository.save(orderItem);
        return orderItem;
    }

    @Override
    public OrderItem parseFile(OrderItem orderItem) {
//        UploadFile uploadFile=orderItem.getUploadFile();
//        FileParse fileParse=new DocParse();
//        fileParse.parse(uploadFile);
//        orderItem=orderItemRepository.save(orderItem);
        return orderItem;
    }

    @Override
    public List<OrderItem> findOrderItemsByIdList(List<Integer> orderItemIds) {
        return orderItemRepository.findOrderItemsByOrderItemIdIn(orderItemIds);
    }
}
