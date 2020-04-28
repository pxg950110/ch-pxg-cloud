package ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi;

import ch.pxg.cloud.chpxgcloudauthorserver.util.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.UUID;

/**
 * <p>
 * 2020/3/18  22:44
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/18
 * @Version 1.0.0
 * @description </p>
 */
@ApiModel(description = "会员注册类")
public class UserRegistVI {

    @ApiModelProperty("注册类型")
    private LoginType registType;

    @ApiModelProperty("消息ID")
    private String messageId;

    @ApiModelProperty("用户名/手机号/邮箱")
    private String userCode;
    //前台加密后传递
    // v1.0版本base64方式加密
    @ApiModelProperty("password")
    private String userPassword;


    public UserRegistVI() {
        this.messageId= CommonUtil.UUID();
    }


    public LoginType getRegistType() {
        return registType;
    }

    public void setRegistType(LoginType registType) {
        this.registType = registType;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMessageId() {
        return messageId;
    }
}
