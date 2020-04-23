package ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 2020/4/23  11:24
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/23
 * @Version 1.0.0
 * @description </p>
 */
@ApiModel(description = "用户注册返回类")
public class UserRegistResponseVI {

    @ApiModelProperty("消息id")
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
