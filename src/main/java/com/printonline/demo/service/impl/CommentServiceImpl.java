package com.printonline.demo.service.impl;

import com.printonline.demo.pojo.Comment;
import com.printonline.demo.repository.CommentRepository;
import com.printonline.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : CommentServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/3
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findCommentByStoreId(Integer storeId) {
        return commentRepository.findCommentsByOrderMaster_StoreStoreId(storeId);
    }
}
