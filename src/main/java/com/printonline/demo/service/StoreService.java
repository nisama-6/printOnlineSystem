package com.printonline.demo.service;

import com.printonline.demo.pojo.Store;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ClassName : StoreService
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/1/28
 **/

public interface StoreService {

    /**
     * 注册一个新的店铺
     * @param store 参数是一个Store对象
     * @return 添加成功返回true,否则返回false
     */
    Boolean addNewStore(Store store);

    /**
     * 查找所有的店铺信息
     * @return 返回一个Store列表
     */
    List<Store> findAllStore();

    /**
     * 分页查询店铺
     * @param currentPage 当前页
     * @param pageSize 总的页数
     * @param sort 排序方式
     * @return 返回Page对象
     */
    Page<Store> findAllStoreByPage(Integer currentPage,Integer pageSize,String sort);

    /**
     * 根据id查询店铺
     * @param id 店铺id
     * @return 返回查到的Store对象
     */
    Store findStoreById(Integer id);

}
