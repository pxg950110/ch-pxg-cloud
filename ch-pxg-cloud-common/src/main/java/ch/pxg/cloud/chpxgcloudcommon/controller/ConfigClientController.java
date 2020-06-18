package ch.pxg.cloud.chpxgcloudcommon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 2020/3/18  20:48
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/18
 * @Version 1.0.0
 * @description </p>
 */
@RestController
@RefreshScope
@Api
public class ConfigClientController {
    @Value("${mail.expire.time}")
    private String prifile;

    @ApiOperation("测试")
    @GetMapping("/profile")
    public String getPrifile(){
        return this.prifile;
    }
}
