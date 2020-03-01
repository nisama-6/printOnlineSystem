package com.printonline.demo.controller.shopper;

import com.printonline.demo.pojo.Comment;
import com.printonline.demo.service.CommentService;
import com.printonline.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName : CommentController
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/3
 **/

@RestController
@RequestMapping(value = "/shopper")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/store/{id}/comments",method = RequestMethod.GET)
    public Result getCommentsByStoreId(@PathVariable("id") Integer storeId){
        List<Comment> commentList=commentService.findCommentByStoreId(storeId);
        return new Result(commentList);
    }

}
