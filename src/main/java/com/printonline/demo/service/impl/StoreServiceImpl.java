package com.printonline.demo.service.impl;

import com.printonline.demo.pojo.Store;
import com.printonline.demo.repository.StoreRepository;
import com.printonline.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : StoreServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/1/28
 **/
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Boolean addNewStore(Store store) {
        Store s=storeRepository.save(store);
        return s != null;
    }

    @Override
    public List<Store> findAllStore() {
        return null;
    }

    @Override
    public Page findAllStoreByPage(Integer currentPage, Integer pageSize, String sort) {
        Sort.Direction mysort =  Sort.Direction.DESC;
        //获取PageRequest对象 index:页码 从0开始  size每页容量 sort排序方式 "id"->properties 以谁为准排序
        Pageable pageable = (Pageable) PageRequest.of(currentPage, pageSize, mysort, sort);
        Page page = storeRepository.findAll(pageable);
        return page;
    }

    @Override
    public Store findStoreById(Integer id) {
        return storeRepository.findStoreByStoreId(id);
    }
}
