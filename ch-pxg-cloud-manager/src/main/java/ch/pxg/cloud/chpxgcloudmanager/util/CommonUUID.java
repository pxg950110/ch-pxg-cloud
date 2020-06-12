package ch.pxg.cloud.chpxgcloudmanager.util;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 2020/6/5  14:49
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/5
 * @Version 1.0.0
 * @description </p>
 */
public class CommonUUID implements Serializable {

    /**
     * 获取唯一的id
     * @return
     */
    public static String UNIQUEID(){
        return new Date().getTime()  //时间搓
        +"-" //随机序列号UUID
        + UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        System.out.println(UNIQUEID());
    }

}
