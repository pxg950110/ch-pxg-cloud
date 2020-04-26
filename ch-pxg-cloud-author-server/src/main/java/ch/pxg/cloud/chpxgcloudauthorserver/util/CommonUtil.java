package ch.pxg.cloud.chpxgcloudauthorserver.util;
import java.io.Serializable;
import java.util.UUID;
/**
 * <p>
 * 2020/4/26  9:25
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/26
 * @Version 1.0.0
 * @description </p>
 */
public class CommonUtil implements Serializable {
    /**
     * 生成uuid替换 -
     * @return
     */
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    /**
     * 生成标准的uuid
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString();
    }
}
