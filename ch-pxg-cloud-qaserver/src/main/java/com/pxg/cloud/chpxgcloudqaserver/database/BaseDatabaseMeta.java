package com.pxg.cloud.chpxgcloudqaserver.database;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 2020/3/26  0:53
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/26
 * @Version 1.0.0
 * @description </p>
 *
 */
@ApiModel
public class BaseDatabaseMeta {
//    name, type, access
    //连接名称
    @ApiModelProperty("连接名称")
    private String connectName;
    // 连接方式 v1.0.0版本不加入
    //private String accessName;
    @ApiModelProperty("ip")
    private String host;
    @ApiModelProperty("端口")
    private String port;
    @ApiModelProperty("数据库名称")
    private String databaseName;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("密码")
    private String password;
    //  驱动类别
    @ApiModelProperty("驱动类别")
    private String driverCLass;
    //数据库类型  暂时不用
//    private String codeType;
    //·


    public String getConnectName() {
        return connectName;
    }

    public void setConnectName(String connectName) {
        this.connectName = connectName;
    }

    public String getUrl(){
        return "";
    }

    public String getDriverCLass() {
        return driverCLass;
    }

    public void setDriverCLass(String driverCLass) {
        this.driverCLass = driverCLass;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
