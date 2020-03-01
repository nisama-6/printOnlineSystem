package com.printonline.demo.tools.qiniuUpload;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName : FileUpload
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/2/14
 **/

public class FileUpload {

    String accessKey = "6F41PkcSjijohUiR9JkH2B52Be9sc5zqTEfmXCJ_";
    String secretKey = "YpMKsS4_QZgjdbCuEDzzFREAh0VNVyK4T_TEck3-";
    String bucket = "res";
    Auth auth = Auth.create(accessKey, secretKey);
//    Auth auth = Auth.create(AccountMgr.ACCESS_KEY, AccountMgr.SECRET_KEY);
    UploadManager uploadManager = new UploadManager();

    /**
     * 获取凭证
     * @param bucketName 空间名称
     * @param key 如果需要覆盖上传则设置此参数
     * @return
     */
    public String getUpToken(String bucketName,String key) {
        return auth.uploadToken(bucketName);
    }

    /**
     * 上传方法1
     * @param filePath 文件路径  （也可以是字节数组、或者File对象）
     * @param key 上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param bucketName 空间名称  （这里是为了获取上传凭证）
     */
    public void upload(String filePath, String key, String bucketName) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(filePath, key, getUpToken(bucketName,key));
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }

    /**
     * 上传方法2
     * @param fileByte 文件
     * @param key 上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param bucketName 空间名称  （这里是为了获取上传凭证）
     */
    public void upload(byte[] fileByte, String key, String bucketName) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(fileByte, key, getUpToken(bucketName,key));
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }

    /**
     * 上传方法3 覆盖上传
     * @param path
     *            上传文件路径
     * @param bucketName
     *            空间名
     * @param key
     *            文件名
     */
    public void overrideUpload(String path, String key, String bucketName) {
        try {
            String token = getUpToken(bucketName, key);//获取 token
            Response response = uploadManager.put(path, key, token);//执行上传，通过token来识别 该上传是“覆盖上传”
            System.out.println(response.toString());
        } catch (QiniuException e) {
            System.out.println(e.response.statusCode);
            e.printStackTrace();
        }
    }
    /**
     * 主函数：程序入口，测试功能
     * @param args
     */
    public static void main(String[] args) {
        // 上传文件的路径，因为在Mac下，所以路径和windows下不同
        String filePath = "/Users/niran/Desktop/3160608065-倪然-生产实习.zip";
        // 要上传的空间
        String bucketName = "res";
        // 上传到七牛后保存的文件名
        String key = "sometext.txt";
        // 这里的filepath可以直接替换成File如下注释所示
        // File file=new File(filePath);
        // new SimpleUpload().upload(file, key, bucketName);
        new FileUpload().upload(filePath, key, bucketName);
    }

}
