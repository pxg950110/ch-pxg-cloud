package ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

/**
 * <p>
 * 2020/3/17  14:26
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
@ApiModel
public class UserVI {
    //  用户注册页面
    @ApiModelProperty("msgId")
    private String msgId;//消息UUID
    //  账号注册  账号注册默认不需要验证码  但是只有guest 游客的权限
    @ApiModelProperty("用户名")
    private String UserName;
    @ApiModelProperty("密码")
    private String password;
    // 注册的时候默认给user 的权限
    @ApiModelProperty("权限名称")
    private String roleName;
    //  手机号注册   无验证码  必须输入密码  因为无短信验证码的api测试接口
    @ApiModelProperty("电话")
     private String phoneNumber;
    //   private String password;
    //  邮箱注册    有邮箱验证码,验证码信息存放到后台的表中
    @ApiModelProperty("邮箱")
    private String emailUrl;
    @ApiModelProperty("邮箱验证码")
    private String emialCode;
    //  类别
    @ApiModelProperty("注册登录方式")
   private LoginType loginType;
   public UserVI(){
       //消息id
       this.msgId= UUID.randomUUID().toString();
       // 默认的权限 user
       this.roleName="user";
   }

    public String getMsgId() {
        return msgId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailUrl() {
        return emailUrl;
    }

    public void setEmailUrl(String emailUrl) {
        this.emailUrl = emailUrl;
    }

    public String getEmialCode() {
        return emialCode;
    }

    public void setEmialCode(String emialCode) {
        this.emialCode = emialCode;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    @Override
    public String toString() {
        return "UserVI{" +
                "msgId='" + msgId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", password='" + password + '\'' +
                ", roleName='" + roleName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailUrl='" + emailUrl + '\'' +
                ", emialCode='" + emialCode + '\'' +
                ", loginType=" + loginType +
                '}';
    }


}
