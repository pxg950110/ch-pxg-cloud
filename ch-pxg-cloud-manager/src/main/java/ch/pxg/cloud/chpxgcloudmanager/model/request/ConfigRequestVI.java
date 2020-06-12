package ch.pxg.cloud.chpxgcloudmanager.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 2020/6/12  18:06
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/12
 * @Version 1.0.0
 * @description </p>
 */
@ApiModel
@Data
public class ConfigRequestVI {

    @ApiModelProperty("服务id")
    private Integer serverId;

}
