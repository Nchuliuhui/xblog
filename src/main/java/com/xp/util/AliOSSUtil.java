package com.xp.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

/**
 * @Author xp
 * @Description aliyunOss图片上传工具类
 * @Date 2017/8/7 08:08
 */
public class AliOSSUtil {

    private static Logger logger   =   LoggerFactory.getLogger(AliOSSUtil.class);

    private static String END_POINT = "oss-cn-shanghai.aliyuncs.com";

    //@Value("${aliyun.oss.accessKey}")
    private static String ACCESS_KEY_ID = "LTAIfKWKYNEF1ipI";

    //@Value("${aliyun.oss.accessKeySecret}")
    private static String ACCESS_KEY_SECRET = "qYTIS76T9GHcoqCzUI2NRr8uIFlix8";

    //@Value("${aliyun.oss.bucketName}")
    private static String BUCKET_NAME = "yukongaaa-img-upload";


    public static String upload(InputStream file) throws FileNotFoundException {
        if(file == null){
            return null;
        }
        //创建OSS Client
        OSSClient ossClient = new OSSClient(END_POINT,ACCESS_KEY_ID,ACCESS_KEY_SECRET);
        //判断文件容器是否存在 不存在则创建
        if(!ossClient.doesBucketExist(BUCKET_NAME)){
            ossClient.createBucket(BUCKET_NAME);
            CreateBucketRequest createBucketRequest = new CreateBucketRequest(BUCKET_NAME);
            createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
            ossClient.createBucket(createBucketRequest);
        }
        // 创建文件路径
        String fileUrl = DateUtil.dateToString2(new Date())  + UUIDUtils.getUUID();
        logger.info("fileUrl :" + fileUrl);
        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentType("image/png");
       // objectMeta.setContentType();
        // 上传文件
        PutObjectResult result = ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileUrl, file,objectMeta));
        if (null != result) {
            logger.info("host:" + "yukongaaa-img-upload.oss-cn-shanghai.aliyuncs.com"+ File.separator + fileUrl);
            return "http://yukongaaa-img-upload.oss-cn-shanghai.aliyuncs.com"+ File.separator + fileUrl;
        }
        return null;
    }
}
