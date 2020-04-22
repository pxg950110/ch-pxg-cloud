package com.pxg.cloud.chpxgcloudqaserver.controller;

import com.pxg.cloud.chpxgcloudqaserver.database.BaseDatabaseMeta;
import com.pxg.cloud.chpxgcloudqaserver.database.DatabaseTypeEumn;
import com.pxg.cloud.chpxgcloudqaserver.util.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.sql.DatabaseMetaData;
import java.util.Arrays;

/**
 * <p>
 * 2020/3/26  0:35
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/26
 * @Version 1.0.0
 * @description </p>
 */
@RestController
@Api("测试")
public class TestController {
    private final Logger log= LoggerFactory.getLogger(TestController.class);
    @ApiOperation("测试")
    @PostMapping("/test")
    public String test(@RequestBody BaseDatabaseMeta baseDatabaseMeta){
        log.info(baseDatabaseMeta.toString());
        return "test info";
    }

}
