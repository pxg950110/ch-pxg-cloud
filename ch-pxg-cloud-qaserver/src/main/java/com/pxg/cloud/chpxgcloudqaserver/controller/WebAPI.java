package com.pxg.cloud.chpxgcloudqaserver.controller;

import com.pxg.cloud.chpxgcloudqaserver.database.DatabaseTypeEumn;
import com.pxg.cloud.chpxgcloudqaserver.model.request.ApiCommonRequestVI;
import com.pxg.cloud.chpxgcloudqaserver.model.request.ApiConfigRequestVi;
import com.pxg.cloud.chpxgcloudqaserver.model.request.DataSourceRequestVI;
import com.pxg.cloud.chpxgcloudqaserver.service.CommonApiService;
import com.pxg.cloud.chpxgcloudqaserver.service.DataSourceService;
import com.pxg.cloud.chpxgcloudqaserver.util.ApiTypeEnum;
import com.pxg.cloud.chpxgcloudqaserver.util.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 2020/3/26  18:57
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
//@RequestMapping("/datasource")
@Api
public class WebAPI {
    @Autowired
    private DataSourceService dataSourceService;

    @Autowired
    private CommonApiService commonApiService;
    @ApiOperation("测试连接是否成功")
    @PostMapping("/test/conntect")
    public ResultInfo connenctTest(@RequestBody DataSourceRequestVI dataSourceRequestVI){
        return dataSourceService.checkConntect(dataSourceRequestVI);
    }

    @ApiOperation("保存数据源")
    @PostMapping("/datasource/save")
    public ResultInfo savaDataSource(@RequestBody DataSourceRequestVI dataSourceRequestVI){
        return dataSourceService.savaDataSource(dataSourceRequestVI);
    }

    @ApiOperation("获取所有的数据源")
    @GetMapping("/datasource/all")
    public ResultInfo getDataSource(){
        return dataSourceService.getDataSource();
    }

    @GetMapping("/database/type/all")
    @ApiOperation("获取可用的数据库类型")
    public ResultInfo getDatabaseTypeInfo(){
        return ResultInfo.ok(DatabaseTypeEumn.getAllEumn());
    }


     /*
     *后台数据接口配置
     */
    //
    @ApiOperation("获取所有配置类型")
    @GetMapping("/api/config/type")
    public ResultInfo getApiType(){
        return ResultInfo.ok(ApiTypeEnum.getAllEumn());
    }

    @ApiOperation("保存数据源接口配置")
    @PostMapping("/api/config/save")
    public ResultInfo saveApiInfo(@RequestBody  ApiConfigRequestVi requestVi){
        return dataSourceService.saveApiInfo(requestVi);
    }


    @ApiOperation("通用接口")
    @PostMapping("/common/api/{url}")
    public ResultInfo commonAPI(@PathVariable("url") String url,@RequestBody ApiCommonRequestVI commonRequestVI){
        return commonApiService.getCommonApiResult(url,commonRequestVI);
    }
}
