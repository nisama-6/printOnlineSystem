package com.printonline.demo.repository;

import com.printonline.demo.pojo.Specifications;
import com.printonline.demo.pojo.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName : SpecRepository
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/8
 **/

public interface SpecRepository extends JpaRepository<Specifications, Long> {

    /**
     * 根据店铺id查询打印价格
     * @param storeId 店铺id
     * @return 返回查询到的Specifications对象
     */
    List<Specifications> findSpecificationsByStore_StoreId(Integer storeId);
}
