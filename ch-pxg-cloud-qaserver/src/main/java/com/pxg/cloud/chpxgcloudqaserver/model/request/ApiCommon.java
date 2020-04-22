package com.pxg.cloud.chpxgcloudqaserver.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 2020/4/3  11:06
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
@ApiModel("标准接口调用")
public class ApiCommon {

//    private  String apiParamId;
    @ApiModelProperty("参数code")
    private String apiParamCode;
    @ApiModelProperty("参数值")
    private String apiParamValue;

    public String getApiParamCode() {
        return apiParamCode;
    }

    public void setApiParamCode(String apiParamCode) {
        this.apiParamCode = apiParamCode;
    }

    public String getApiParamValue() {
        return apiParamValue;
    }

    public void setApiParamValue(String apiParamValue) {
        this.apiParamValue = apiParamValue;
    }
}
