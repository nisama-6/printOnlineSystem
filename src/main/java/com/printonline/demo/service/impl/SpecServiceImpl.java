package com.printonline.demo.service.impl;

import com.printonline.demo.pojo.Specifications;
import com.printonline.demo.repository.SpecRepository;
import com.printonline.demo.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : SpecServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/8
 **/
@Service
public class SpecServiceImpl implements SpecService {

    @Autowired
    private SpecRepository specRepository;
    @Override
    public List<Specifications> findSepcsByStoreId(Integer storeId) {

        return specRepository.findSpecificationsByStore_StoreId(storeId);
    }
}
