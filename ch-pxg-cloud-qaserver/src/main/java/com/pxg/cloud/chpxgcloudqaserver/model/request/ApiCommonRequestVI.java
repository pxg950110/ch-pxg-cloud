package com.pxg.cloud.chpxgcloudqaserver.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <p>
 * 2020/4/3  11:05
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
@ApiModel("通用接口调用方式")
public class ApiCommonRequestVI {
    @ApiModelProperty("消息ID")
    private  String messageId;
    @ApiModelProperty("参数")
    private List<ApiCommon> apiCommonList;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public List<ApiCommon> getApiCommonList() {
        return apiCommonList;
    }

    public void setApiCommonList(List<ApiCommon> apiCommonList) {
        this.apiCommonList = apiCommonList;
    }
}
