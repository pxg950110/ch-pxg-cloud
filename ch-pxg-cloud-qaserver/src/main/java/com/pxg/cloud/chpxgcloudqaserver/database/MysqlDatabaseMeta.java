package com.pxg.cloud.chpxgcloudqaserver.database;

/**
 * <p>
 * 2020/3/26  1:13
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
 */
public class MysqlDatabaseMeta extends BaseDatabaseMeta {

    /**
     * 初始化设置
     */
    public MysqlDatabaseMeta() {
        this.setDriverCLass("com.mysql.cj.jdbc.Driver");
        this.getUrl();
    }

    /**
     * mysql的url
     * @return
     */
    @Override
    public String getUrl() {
        return "jdbc:mysql://" + this.getHost() + ":" + this.getPort() + "/" + this.getDatabaseName();
    }


}
