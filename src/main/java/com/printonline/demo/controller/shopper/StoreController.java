package com.printonline.demo.controller.shopper;

import com.printonline.demo.pojo.Store;
import com.printonline.demo.service.StoreService;
import com.printonline.demo.tools.Result;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @ClassName : StoreController
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/1/29
 **/

@RestController
@RequestMapping("/shopper")
public class StoreController {

    @Autowired
    private StoreService storeService;


    @RequestMapping(value = "/stores",method= RequestMethod.GET)
    public Result getAllStore(String sort,Integer currentPage,Integer pageSize){
        Page page=storeService.findAllStoreByPage(currentPage,pageSize,sort);
        return new Result(page);
    }

    @RequestMapping(value="/store/{id}",method = RequestMethod.GET)
    public Result getStoreById(@PathVariable("id") Integer id){
        return new Result(storeService.findStoreById(id));
    }
}
