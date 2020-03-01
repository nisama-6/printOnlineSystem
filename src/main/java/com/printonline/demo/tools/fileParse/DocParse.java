package com.printonline.demo.tools.fileParse;

import com.printonline.demo.pojo.UploadFile;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName : DocParse
 * @Description : TODO docx文件解析类
 * @Author : niran
 * @Date : 2020/2/7
 **/

public class DocParse implements FileParse {


    @Override
    public UploadFile parse(MultipartFile multipartFile) throws IOException {
        InputStream is = multipartFile.getInputStream();
        XWPFDocument doc = new XWPFDocument(is);
        int pages = doc.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
        UploadFile uploadFile=new UploadFile();
        uploadFile.setPageNum(pages);
        return uploadFile;
    }
}
