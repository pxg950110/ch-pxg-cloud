package com.pxg.cloud.chpxgcloudqaserver.database;

/**
 * <p>
 * 2020/4/2  18:48
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/2
 * @Version 1.0.0
 * @description </p>
 */
public class MSSQLDatabaseMeta extends  BaseDatabaseMeta {


    public MSSQLDatabaseMeta() {
        this.getUrl();
//        com.microsoft.sqlserver.jdbc.SQLServerDriver
        this.setDriverCLass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    @Override
    public String getUrl() {
        return  "jdbc:sqlserver://"+this.getHost()+":"+this.getPort()+"; DatabaseName="+this.getDatabaseName()+"";
    }
}
