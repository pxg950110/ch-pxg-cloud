package ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi;

import ch.pxg.cloud.chpxgcloudauthorserver.util.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.UUID;

/**
 * <p>
 * 2020/3/18  22:44
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

    @ApiModelProperty("手机号/邮箱")
    private String userCode;
    //  用户名  必填项
    private String userName;
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
