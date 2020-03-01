package com.printonline.demo.controller.shopper;

import com.printonline.demo.pojo.Specifications;
import com.printonline.demo.service.SpecService;
import com.printonline.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName : SpecController
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/8
 **/
@RestController
@RequestMapping("/shopper")
public class SpecController {

    @Autowired
    private SpecService specService;

    @RequestMapping(value = "/stores/{storeId}/specs", method = RequestMethod.GET)
    public Result findSpecsByStoreId(@PathVariable("storeId") Integer storeId) {
        List<Specifications> specificationsList = specService.findSepcsByStoreId(storeId);

        return new Result(specificationsList);
    }

}
