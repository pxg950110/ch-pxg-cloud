package ch.pxg.cloud.chpxgcloudrabbitmq.producer;

import java.io.Serializable;

/**
 * <p>
 * 2020/3/17  22:11
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
public class EmailCodeVI implements Serializable {

    // 发送邮件验证码的类
    private String msgId;
    // 对方邮箱地址
    private String emailUrl;
    // 生成验证码 // 不在此类中


    public EmailCodeVI() {
    }

    public EmailCodeVI(String msgId, String emailUrl) {
        this.msgId = msgId;
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
