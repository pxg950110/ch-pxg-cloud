package com.pxg.cloud.chpxgcloudqaserver.database;

import org.postgresql.Driver;

/**
 * <p>
 * 2020/3/26  1:15
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
public class PostgresDatabaseMeta extends BaseDatabaseMeta {

    public PostgresDatabaseMeta() {
        this.setDriverCLass("org.postgresql.Driver");
        this.getUrl();
    }

    /**
     * postgres的url
     * @return
     */
    @Override
    public String getUrl() {
        return "jdbc:postgresql://" + this.getHost() + ":" + this.getPort() + "/" + this.getDatabaseName();
    }
}
