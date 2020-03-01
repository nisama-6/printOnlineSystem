package com.printonline.demo.service;

import com.printonline.demo.pojo.Comment;

import java.util.List;

/**
 * @ClassName : CommentService
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/3
 **/

public interface CommentService {

    /**
     * 通过店铺id查询店铺评论
     * @param storeId 店铺id
     * @return 返回一个List
     */
    List<Comment> findCommentByStoreId(Integer storeId);
}
