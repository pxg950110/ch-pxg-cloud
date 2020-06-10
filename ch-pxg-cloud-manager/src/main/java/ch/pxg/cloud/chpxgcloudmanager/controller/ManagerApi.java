package ch.pxg.cloud.chpxgcloudmanager.controller;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 2020/6/9  14:28
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/9
 * @Version 1.0.0
 * @description </p>
 */
@RestController
public class ManagerApi {

    @ApiOperation("测试")
    @GetMapping("test")
    public String test() {
        return "测试";
    }
}
