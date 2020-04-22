package ch.pxg.cloud.chpxgcloudwechat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 2020/2/23  16:19
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/2/23
 * @Version 1.0.0
 * @description </p>
 */
//@Configuration
public class WxProgramConfig {

//    var appId = "wx80938987e535a515"
//    var secret = "1050557166a7fdf14d422805fe9338ac"
    //https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    /**
     * AppID(小程序ID)
     */
//    @Value("")
    public static final String APPID = "wx80938987e535a515";

    /**
     * AppSecret(小程序密钥)
     */
    public static final String SECRET="1050557166a7fdf14d422805fe9338ac";


    // uuid
    public static String MCH_ID = "";

    /**
     * 回调地址
     */
    public static String NOTIFY_URL = "";

    //
    public static String KEY = "";

}
