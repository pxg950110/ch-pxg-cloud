package ch.pxg.cloud.chpxgcloudauthorserver.util;


import org.springframework.util.DigestUtils;

/**
 * <p>
 * 2020/7/2  14:24
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/7/2
 * @Version 1.0.0
 * @description
 * md5加密和验证
 * </p>
 */
public class Md5Util {

    public static  String md5Encode(String password){
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    public static Boolean md5Check(String inPassword,String password){
        return DigestUtils.md5DigestAsHex(inPassword.getBytes()).equals(password);

    }
}
