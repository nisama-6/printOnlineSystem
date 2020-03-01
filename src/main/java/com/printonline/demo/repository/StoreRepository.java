package com.printonline.demo.repository;

import com.printonline.demo.pojo.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @ClassName : StoreRepository
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/1/28
 **/

public interface StoreRepository extends PagingAndSortingRepository<Store, Long> {

    /**
     * 查询所有店铺
     * @return 返回封装Store的List
     */
    @Override
    List<Store> findAll();

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Override
    Page<Store> findAll(Pageable pageable);

    /**
     * 根据id查询店铺
     * @param id 店铺id
     * @return 返回查到的Store对象
     */
    Store findStoreByStoreId(Integer id);

}
