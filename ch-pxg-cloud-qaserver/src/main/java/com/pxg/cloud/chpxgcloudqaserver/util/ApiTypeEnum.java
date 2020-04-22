package com.pxg.cloud.chpxgcloudqaserver.util;

import com.google.common.collect.Lists;
import com.pxg.cloud.chpxgcloudqaserver.database.DatabaseTypeEumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ch_pxg
 * @emial pxg950110@163.com
 * @version  1.0.0
 */
public enum ApiTypeEnum  implements BaseEnum{
    /**
     * v1.0版本只支持sql 配置
     */
    SQL(1,"SQL","SQL语句配置","","","");

    long id;
    String code;
    String desription;
    String className;
    String TypeConfigClass;
    String extent;

    ApiTypeEnum(long id, String code, String desription, String className, String typeConfigClass, String extent) {
        this.id = id;
        this.code = code;
        this.desription = desription;
        this.className = className;
        TypeConfigClass = typeConfigClass;
        this.extent = extent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTypeConfigClass() {
        return TypeConfigClass;
    }

    public void setTypeConfigClass(String typeConfigClass) {
        TypeConfigClass = typeConfigClass;
    }

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }

    /**
     * 获取获取枚举
     * @return
     */
    public static List<ApiTypeEnum> getAllEumn() {
        List<ApiTypeEnum> list = new ArrayList<>();
        list.addAll(Arrays.asList(values()));
        return list;
    }

}
