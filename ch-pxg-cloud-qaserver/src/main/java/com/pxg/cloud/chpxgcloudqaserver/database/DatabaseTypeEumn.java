package com.pxg.cloud.chpxgcloudqaserver.database;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.pxg.cloud.chpxgcloudqaserver.util.BaseEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 2020/3/26  9:12
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
 * 数据库类型的枚举
 */
public enum DatabaseTypeEumn implements BaseEnum {
    MYSQL(1, "mysql", "com.pxg.cloud.chpxgcloudqaserver.database.MysqlDatabaseMeta",
            "3306"),
    //sqlserver
    MSSQL(3,"sqlServer","com.pxg.cloud.chpxgcloudqaserver.database.MSSQLDatabaseMeta","1433"),
    POSTGRESQL(2, "postgresql", "com.pxg.cloud.chpxgcloudqaserver.database.PostgresDatabaseMeta", "5432");


    // 其他数据库暂未加入 待后续加入

    //id
    private long id;
    //名称
    private String name;
    //数据源所用的类
    private String classMetaName;
    //默认的端口
    private String defaultPort;


    DatabaseTypeEumn(long id, String name, String classMetaName, String defaultPort) {
        this.id = id;
        this.name = name;
        this.classMetaName = classMetaName;
        this.defaultPort = defaultPort;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassMetaName() {
        return classMetaName;
    }

    public void setClassMetaName(String classMetaName) {
        this.classMetaName = classMetaName;
    }

    public String getDefaultPort() {
        return defaultPort;
    }

    public void setDefaultPort(String defaultPort) {
        this.defaultPort = defaultPort;
    }

    public static DatabaseTypeEumn getDatabaseTypeEumnById(long id) {
        for (DatabaseTypeEumn databaseTypeEumn : DatabaseTypeEumn.values()) {
            if (databaseTypeEumn.getId() == id) {
                return databaseTypeEumn;
            }
        }
        return null;
    }

    public static DatabaseTypeEumn getDatabaseTypeEumnByCode(String name){
        for(DatabaseTypeEumn databaseTypeEumn:DatabaseTypeEumn.values()){
            if (databaseTypeEumn.getName().equals(name)){
                return databaseTypeEumn;
            }
        }
        return null;
    }

    /**
     * 获取获取枚举
     * @return
     */
    public static List<DatabaseTypeEumn> getAllEumn() {
        List<DatabaseTypeEumn> list = new ArrayList<>();
        list.addAll(Arrays.asList(values()));
        return list;
    }

    /**
     * 获取全部枚举值
     * @return List<String>
     */
    public static List<String> getAllEnumCode() {
        List<String> list = Lists.newArrayList();
        for (DatabaseTypeEumn each : values()) {
            list.add(each.getName());
        }
        return list;
    }

}
