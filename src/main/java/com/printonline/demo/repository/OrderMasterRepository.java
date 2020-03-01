package com.printonline.demo.repository;

import com.printonline.demo.pojo.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName : OrderMasterRepository
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/15
 **/

public interface OrderMasterRepository extends JpaRepository<OrderMaster, Long> {



}
