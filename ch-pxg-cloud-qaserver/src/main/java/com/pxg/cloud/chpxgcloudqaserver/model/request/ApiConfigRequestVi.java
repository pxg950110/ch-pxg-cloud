package com.pxg.cloud.chpxgcloudqaserver.model.request;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <p>
 * 2020/4/3  1:31
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/3
 * @Version 1.0.0
 * @description </p>
 */
@ApiModel
public class ApiConfigRequestVi {
    @ApiModelProperty("接口名称")
    private String apiName;
    @ApiModelProperty("接口地址")
    private String apiUrl;
    @ApiModelProperty("接口类型")
    private String apiTypeCode;
    @ApiModelProperty("sql语句")
    private String apiSQL;
    @ApiModelProperty("数据源")
    private String dataSourceId;
    @ApiModelProperty("接口配置")
    private List<ParamList> paramList;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiTypeCode() {
        return apiTypeCode;
    }

    public void setApiTypeCode(String apiTypeCode) {
        this.apiTypeCode = apiTypeCode;
    }

    public String getApiSQL() {
        return apiSQL;
    }

    public void setApiSQL(String apiSQL) {
        this.apiSQL = apiSQL;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public List<ParamList> getParamList() {
        return paramList;
    }

    public void setParamList(List<ParamList> paramList) {
        this.paramList = paramList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
