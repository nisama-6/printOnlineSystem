package com.printonline.demo;

import com.printonline.demo.pojo.OrderItem;
import com.printonline.demo.repository.OrderItemRepository;
import com.printonline.demo.repository.OrderMasterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Test
    void contextLoads() {
        List<Integer> orderList=new ArrayList<>();
        orderList.add(79);
        orderList.add(80);
        List<OrderItem> orderItems=orderItemRepository.findOrderItemsByOrderItemIdIn(orderList);
        Integer a=1;

    }

}
