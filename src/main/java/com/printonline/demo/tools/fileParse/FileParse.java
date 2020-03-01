package com.printonline.demo.tools.fileParse;

import com.printonline.demo.pojo.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName : fileParse
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/7
 **/

public interface FileParse {

    /**
     * 解析Doc文档
     * @param multipartFile 文件的url
     * @return 返回UploadFile对象
     */
    UploadFile parse(MultipartFile multipartFile) throws IOException;
}
