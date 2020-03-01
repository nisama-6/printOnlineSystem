package com.printonline.demo.controller.shopper;

import com.printonline.demo.pojo.OrderItem;
import com.printonline.demo.pojo.UploadFile;
import com.printonline.demo.service.OrderItemService;
import com.printonline.demo.service.UploadFileService;
import com.printonline.demo.tools.Result;
import com.printonline.demo.tools.qiniuUpload.FileUpload;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.*;
import java.net.SocketException;

/**
 * @ClassName : UploadFileController
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/7
 **/
@RestController
@RequestMapping("/shopper")
public class UploadFileController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private UploadFileService uploadFileService;

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public Result parseFile(@RequestBody OrderItem orderItem){
        orderItem=orderItemService.parseFile(orderItem);
        return new Result(orderItem);
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Result upload(@RequestParam("file") MultipartFile multipartFile) throws  IOException, ServletException {
        UploadFile uploadFile=uploadFileService.upload(multipartFile);
        if(uploadFile.getFileUrl()==null) {
            throw new ServletException("上传失败!");
        }
        return new Result(uploadFile);
        // 获取文件名
//        String fileName = multipartFile.getOriginalFilename();
//
//        new FileUpload().upload(multipartFile.getBytes(),"test3/"+fileName,"res");
//        InputStream is = multipartFile.getInputStream();
//        XWPFDocument doc = new XWPFDocument(is);
//
//        //总页数
//        int pages = doc.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
//
//
//        return String.valueOf(pages);

    }

}
