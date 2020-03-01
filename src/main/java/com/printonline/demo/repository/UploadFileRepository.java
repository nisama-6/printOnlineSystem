package com.printonline.demo.repository;

import com.printonline.demo.pojo.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName : UploadFileRepository
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/7
 **/

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {
}
