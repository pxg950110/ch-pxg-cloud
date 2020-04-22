package com.pxg.cloud.chpxgcloudqaserver.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>
 * 2020/3/26  0:54
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

public  class Database implements Serializable {

    private static  Logger log=LoggerFactory.getLogger(Database.class);

    /**
     * @param baseDatabaseMeta
     * @param logDetial  日志
     * @return
     */
    public static Connection connect(BaseDatabaseMeta baseDatabaseMeta,Logger logDetial ){
        Connection connection=null;
        try {
            // driverclass
            //mysql驱动
            Class.forName(baseDatabaseMeta.getDriverCLass());
            String url=baseDatabaseMeta.getUrl();
            Properties properties=new Properties();
            properties.setProperty("user",baseDatabaseMeta.getUserName());
            properties.setProperty("password",baseDatabaseMeta.getPassword());
            logDetial.info("数据库连接地址--{}",baseDatabaseMeta.getUrl());
             connection= DriverManager.getConnection(url,properties);
             logDetial.info("连接成功");
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            logDetial.error(e.getMessage());
        }
        return null;
    }
    //

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //
//        DatabaseTypeEumn databaseTypeEume=DatabaseTypeEumn.getDatabaseTypeEumnByIdOrCode(null,"postgresql");
        //java反射实现初始化父类
//        assert databaseTypeEume != null;
//        Class className=Class.forName(databaseTypeEume.getClassMetaName());
//        BaseDatabaseMeta baseDatabaseMeta=(BaseDatabaseMeta) className.newInstance();
//        baseDatabaseMeta.setHost("192.168.56.1");
//        baseDatabaseMeta.setPort("3306");
//        baseDatabaseMeta.setDatabaseName("mysql");
//        baseDatabaseMeta.setUserName("root");
//        baseDatabaseMeta.setPassword("123456");
//        Connection connection=connect(baseDatabaseMeta,log);
//        connection.close();
    }
    //
}
