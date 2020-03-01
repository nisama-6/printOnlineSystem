package com.printonline.demo.repository;

import com.printonline.demo.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName : CommentRepository
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/3
 **/

public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * 根据店铺id查询评论
     * @param id 店铺的id
     * @return
     */
    List<Comment> findCommentsByOrderMaster_StoreStoreId(Integer id);

}
