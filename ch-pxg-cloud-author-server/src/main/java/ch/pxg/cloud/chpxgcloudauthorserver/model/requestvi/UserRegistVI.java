package ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi;

import ch.pxg.cloud.chpxgcloudauthorserver.util.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.UUID;

/**
 * <p>
 * 2020/3/18  22:44
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/18
 * @Version 1.0.0
 * @description </p>
 */
@ApiModel(description = "会员注册类")
public class UserRegistVI {

    @ApiModelProperty("消息ID")
    private String messageId;

    public UserRegistVI() {
        this.messageId= CommonUtil.UUID();
    }

    public String getMessageId() {
        return messageId;
    }
}
