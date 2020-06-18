package ch.pxg.cloud.chpxgcloudauthorserver.util;

import java.util.UUID;

/**
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/17
 * @Version 1.0.0
 * @description </p>
 */
public class EmailCodeVI {


    // 发送邮件验证码的类
    private String msgId;
    // 对方邮箱地址
    private String emailUrl;
    // 生成验证码 // 不在此类中


    public EmailCodeVI() {
    }


    public EmailCodeVI(String emailUrl) {
        this.msgId= CommonUtil.UUID();
        this.emailUrl = emailUrl;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getEmailUrl() {
        return emailUrl;
    }

    public void setEmailUrl(String emailUrl) {
        this.emailUrl = emailUrl;
    }

    @Override
    public String toString() {
        return "EmailCodeVI{" +
                "msgId='" + msgId + '\'' +
                ", emailUrl='" + emailUrl + '\'' +
                '}';
    }
}
