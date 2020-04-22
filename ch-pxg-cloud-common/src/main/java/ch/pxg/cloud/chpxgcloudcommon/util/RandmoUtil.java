package ch.pxg.cloud.chpxgcloudcommon.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * <p>
 * 2020/3/17  17:11
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/17
 * @Version 1.0.0
 * @description </p>
 */
public class RandmoUtil {
private  static Logger log= LoggerFactory.getLogger(RandmoUtil.class);
    /**
     * 生成 验证码 长度 codeLen
     * @param codeLen
     * @return
     */
    public static  String getCode(int codeLen){
        String result="";
        Random random=new Random();
        for (int i=0;i<codeLen;i++){
            result+=random.nextInt(10)+"";
        }
        // 生成

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getCode(6));

    }
}
