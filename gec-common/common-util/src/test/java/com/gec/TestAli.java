package com.gec;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author 陈君哲
 */
public class TestAli{
    public static void main(String[] args) throws FileNotFoundException {
        // 区域
        String endpoint = "oss-cn-guangzhou.aliyuncs.com";

        // 秘钥
        String accessKeyId = "LTAI5tJCEZ4pymxD4gMj1v7x";
        String accessKeySecret = "gVpXPIrJI53vEP03hD5jDc44b2Kida";

        //创建oss客户端
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件
        InputStream inputStream = new FileInputStream("C:\\Users\\14700\\Pictures\\UbisoftConnect\\人鱼.jpg");
        ossClient.putObject("everyday-movies", "abc2.jpg", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
    }


}
