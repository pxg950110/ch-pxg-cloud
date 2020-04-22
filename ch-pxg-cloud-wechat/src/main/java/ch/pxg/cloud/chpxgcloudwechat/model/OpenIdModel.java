package ch.pxg.cloud.chpxgcloudwechat.model;

/**
 * <p>
 * 2020/2/23  16:58
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
public class OpenIdModel {
    private  String openId;
    private String sessionKey;

    public OpenIdModel() {
    }

    public OpenIdModel(String openId, String sessionKey) {
        this.openId = openId;
        this.sessionKey = sessionKey;
    }

    @Override
    public String toString() {
        return "OpenIdModel{" +
                "openId='" + openId + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                '}';
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
