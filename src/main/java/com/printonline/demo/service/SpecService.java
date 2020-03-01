package com.printonline.demo.service;

import com.printonline.demo.pojo.Specifications;

import java.util.List;

/**
 * @ClassName : SpecService
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/8
 **/

public interface SpecService {

    /**
     * 根据店铺id查询打印价格
     * @param storeId 店铺id
     * @return 返回查询到的Specifications对象
     */
    List<Specifications> findSepcsByStoreId(Integer storeId);
}
