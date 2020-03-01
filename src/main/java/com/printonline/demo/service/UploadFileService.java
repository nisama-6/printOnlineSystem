package com.printonline.demo.service;

import com.printonline.demo.pojo.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName : UploadFIleService
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/7
 **/

public interface UploadFileService {

    /**
     * 更新UploadFile
     * @param uploadFile UploadFile对象
     * @return 返回更新后的Upload对象
     */
    UploadFile save(UploadFile uploadFile);

    /**
     * 上传文件
     * @param multipartFile 客户端接收的参数
     * @return 返回解析上传后的UploadFile对象
     */
    UploadFile upload(MultipartFile multipartFile) throws IOException;
}
