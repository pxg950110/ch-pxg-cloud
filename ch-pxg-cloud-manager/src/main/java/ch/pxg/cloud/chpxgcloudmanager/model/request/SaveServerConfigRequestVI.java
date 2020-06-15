package ch.pxg.cloud.chpxgcloudmanager.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 2020/6/15  9:47
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/15
 * @Version 1.0.0
 * @description </p>
 */
@Data
public class SaveServerConfigRequestVI {
    @ApiModelProperty("key")
    private String propertyKey;
    @ApiModelProperty("value")
    private String propertyValue;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("id")
    private Integer propertyId;
    @ApiModelProperty("服务id")
    private Integer serverId;

}

