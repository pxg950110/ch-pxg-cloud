package ch.pxg.cloud.chpxgcloudswaggerui.controller;

import ch.pxg.cloud.chpxgcloudswaggerui.feignclient.RabbitServerFeignClient;
import ch.pxg.cloud.chpxgcloudswaggerui.service.TestService;
import ch.pxg.cloud.chpxgcloudswaggerui.service.impl.TestServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 2020/2/28  11:28
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/2/28
 * @Version 1.0.0
 * @description </p>
 */
@RestController
@Api("test")
public class WechatApi {
    @Autowired
    TestService testService;

    @GetMapping("/")
    @ApiOperation("测试")
    public String hello(){
        return "hello swagger-ui"+testService.test();
    }


    @GetMapping("/python/gushi")
    @ApiOperation("获取python爬虫中的故事列表")
    public Object test2(String url){
        return testService.test2(url);
    }

}

