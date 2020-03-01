package com.printonline.demo.service.impl;

import com.printonline.demo.pojo.UploadFile;
import com.printonline.demo.repository.UploadFileRepository;
import com.printonline.demo.service.UploadFileService;
import com.printonline.demo.tools.fileParse.DocParse;
import com.printonline.demo.tools.fileParse.FileParse;
import com.printonline.demo.tools.qiniuUpload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName : UploadFileServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/8
 **/
@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Autowired
    private UploadFileRepository uploadFileRepository;

    @Override
    public UploadFile save(UploadFile uploadFile) {
        return uploadFileRepository.save(uploadFile);
    }

    @Override
    public UploadFile upload(MultipartFile multipartFile) throws IOException {

        String fileName = multipartFile.getOriginalFilename();
        new FileUpload().upload(multipartFile.getBytes(),"test3/"+fileName,"res");
        FileParse fileParse=new DocParse();
        UploadFile uploadFile=fileParse.parse(multipartFile);
        uploadFile.setFileUrl("http://download.niran.vip/test3/"+fileName);
        uploadFile.setFileName(fileName);
        return uploadFile;
    }
}
