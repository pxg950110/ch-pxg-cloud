package ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi;

import ch.pxg.cloud.chpxgcloudauthorserver.util.CommonUtil;

/**
 * <p>
 * 2020/3/7  18:48
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/7
 * @Version 1.0.0
 * @description </p>
 */
public class UserInfoVi {
    /**
     * 用户登录后产生的唯一id
     */
    private String messageId;
    private String token ;
    public UserInfoVi() {
        this.messageId= CommonUtil.UUID();
    }

    public UserInfoVi(String token) {
        this.messageId= CommonUtil.UUID();
        this.token = token;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessageId() {
        return messageId;
    }


}
