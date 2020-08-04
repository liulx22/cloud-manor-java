package com.buba.cloud.cloudManor.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Random;

/**
 * @Classname OSSClientUtil
 * @Description 阿里云 OSS文件类
 * @Date 2020/8/3 16:50
 * @Created by liulx
 */
public class OSSClientUtil {
    private String endpoint = "oss-cn-beijing.aliyuncs.com";
    // accessKey
    private String accessKeyId = "LTAI4GKubqFp1tNQUGNY77nu";
    private String accessKeySecret = "amRS0xfVQWZ4BGdrcYneSflZeQZK28";
    //空间
    private String bucketName = "zhuiyun1";
    //文件存储目录
    private String filedir = "CloudManor_Pic/";

    private OSSClient ossClient;

    public OSSClientUtil() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 初始化
     */
    public void init() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 销毁
     */
    public void destory() {
        ossClient.shutdown();
    }

   /**
    * 上传用户头像
    * */
   public String uploadUserHead(MultipartFile file,String imagName) {
       String rect="";
       if (file.getSize() > 1024 * 1024) {
           System.out.println("上传图片大小不能超过1M！");
       }
       try {
           InputStream inputStream = file.getInputStream();
           rect= this.uploadFile2OSS(inputStream, "/userHead/"+imagName);
       } catch (Exception e) {
           System.out.println("图片上传失败");
       }
       return rect;
   }
    /**
     * 上传系统图片
     * */
    public String uploadGloablePictrue(MultipartFile file,String imagName) {
        String rect="";
        if (file.getSize() > 1024 * 1024) {
            System.out.println("上传图片大小不能超过1M！");
        }
        try {
            InputStream inputStream = file.getInputStream();
            rect=this.uploadFile2OSS(inputStream, "/gloablePictrue/"+imagName);
        } catch (Exception e) {
            System.out.println("图片上传失败");
        }
        return rect;
    }
    /**
     * 上传资源封面图
     * */
    public String uploadResourcePictrue(MultipartFile file,String imagName) {
        String rect="";
        if (file.getSize() > 1024 * 1024) {
            System.out.println("上传图片大小不能超过1M！");
        }
        try {
            InputStream inputStream = file.getInputStream();
            rect=this.uploadFile2OSS(inputStream, "/resource/pictrue/"+imagName);
        } catch (Exception e) {
            System.out.println("图片上传失败");
        }
        return rect;
    }
    /**
     * 上传身份
     * */
    public String uploadResourceIdCard(MultipartFile file,String imagName) {
        String rect="";
        if (file.getSize() > 1024 * 1024) {
            System.out.println("上传图片大小不能超过1M！");
        }
        try {
            InputStream inputStream = file.getInputStream();
            rect=this.uploadFile2OSS(inputStream, "/resource/IdCard/"+imagName);
        } catch (Exception e) {
            System.out.println("图片上传失败");
        }
        return rect;
    }
    /**
     * 上传资源视频
     * */
    public String uploadResourceVido(MultipartFile file,String imagName) {
        String rect="";
        if (file.getSize() > 1024 * 1024) {
            System.out.println("上传图片大小不能超过1M！");
        }
        try {
            InputStream inputStream = file.getInputStream();
            rect=this.uploadFile2OSS(inputStream, "/resource/vido/"+imagName);
        } catch (Exception e) {
            System.out.println("图片上传失败");
        }
        return rect;
    }
    /**
     * 上传农事详情
     * */
    public String uploadResourceDetail(MultipartFile file,String imagName) {
        String rect="";
        if (file.getSize() > 1024 * 1024) {
            System.out.println("上传图片大小不能超过1M！");
        }
        try {
            InputStream inputStream = file.getInputStream();
            rect= this.uploadFile2OSS(inputStream, "/resource/detail/"+imagName);
        } catch (Exception e) {
            System.out.println("图片上传失败");
        }
        return rect;
    }
    /**
     * 上传农事记录
     * */
    public String uploadResourceRecord(MultipartFile file,String imagName) {
        String rect="";
        if (file.getSize() > 1024 * 1024) {
            System.out.println("上传图片大小不能超过1M！");
        }
        try {
            InputStream inputStream = file.getInputStream();
            rect=this.uploadFile2OSS(inputStream, "/resource/record/"+imagName);
        } catch (Exception e) {
            System.out.println("图片上传失败");
        }
        return rect;
    }
    public void uploadImg2Oss(MultipartFile file,String imagName) {
        if (file.getSize() > 1024 * 1024) {
            System.out.println("上传图片大小不能超过1M！");
        }
       try {
            InputStream inputStream = file.getInputStream();
            this.uploadFile2OSS(inputStream, imagName);
        } catch (Exception e) {
            System.out.println("图片上传失败");
        }
    }

    /**
     * 获得图片路径
     *
     * @param fileUrl
     * @return
     */
    public String getImgUrl(String fileUrl) {
        if (!StringUtils.isEmpty(fileUrl)) {
            String[] split = fileUrl.split("/");
            return this.getUrl(this.filedir + split[split.length - 1]);
        }
        return null;
    }

    /**
     * 上传到OSS服务器  如果同名文件会覆盖服务器上的
     *
     * @param instream 文件流
     * @param fileName 文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadFile2OSS(InputStream instream, String fileName) {
        String ret = "";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            //上传文件
            PutObjectResult putResult = ossClient.putObject("http://"+bucketName, filedir + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param FilenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }
}
