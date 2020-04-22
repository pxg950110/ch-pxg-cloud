package ch.pxg.cloud.produce.chpxgcloudproduce.controller;

import ch.pxg.cloud.produce.chpxgcloudproduce.service.ProduceServer;
import ch.pxg.cloud.produce.chpxgcloudproduce.util.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 2020/2/28  1:40
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
@Api("后台相关接口")
public class WebAPI {
    @Autowired
    private ProduceServer produceServer;
    @GetMapping("/")
    public  String hello(){
        return "hello world";
    }

    @ApiOperation("通过url获取爬虫中的内容")
    @GetMapping("/python/gushi/list")
    public ResultInfo getContentByUrl(String url){
        return produceServer.getContentByUrl(url);
    }
    @ApiOperation("执行程序吧为空的数据处理")
    @GetMapping("/python/gushi/exec")
    public void exec(){
        produceServer.exec();

    }
}
