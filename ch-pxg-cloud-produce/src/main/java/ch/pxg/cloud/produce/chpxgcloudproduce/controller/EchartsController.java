package ch.pxg.cloud.produce.chpxgcloudproduce.controller;

import ch.pxg.cloud.produce.chpxgcloudproduce.util.ResultInfo;
import com.github.abel533.echarts.option.NoDataLoadingOption;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 2020/4/14  0:27
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/14
 * @Version 1.0.0
 * @description </p>
 * 画图
 */
@RestController
@Api("获取前端图像")
@RequestMapping("/echart")
public class EchartsController {

    @ApiOperation("测试")
    @GetMapping("/test")
    public ResultInfo getEachatsTest(){
        com.github.abel533.echarts.option.NoDataLoadingOption noDataLoadingOption=new NoDataLoadingOption();
        return ResultInfo.ok("null");
    }
}
