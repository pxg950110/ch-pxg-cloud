package ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi;

import lombok.Data;

import java.util.UUID;

/**
 * <p>
 * 2020/6/16  10:40
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/16
 * @Version 1.0.0
 * @description </p>
 */
@Data
public class MailCodeVI {
    // 发送邮箱验证码
    private  String emailUrl;

}
