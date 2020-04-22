package com.pxg.cloud.chpxgcloudqaserver.service.impl;

import com.pxg.cloud.chpxgcloudqaserver.apiconfig.ApiSQLConfig;
import com.pxg.cloud.chpxgcloudqaserver.dao.ApiInfoJPA;
import com.pxg.cloud.chpxgcloudqaserver.dao.DatasourceTableJpa;
import com.pxg.cloud.chpxgcloudqaserver.database.BaseDatabaseMeta;
import com.pxg.cloud.chpxgcloudqaserver.database.Database;
import com.pxg.cloud.chpxgcloudqaserver.database.DatabaseMeta;
import com.pxg.cloud.chpxgcloudqaserver.database.DatabaseTypeEumn;
import com.pxg.cloud.chpxgcloudqaserver.model.ApiInfo;
import com.pxg.cloud.chpxgcloudqaserver.model.DatasourceTable;
import com.pxg.cloud.chpxgcloudqaserver.model.request.ApiConfigRequestVi;
import com.pxg.cloud.chpxgcloudqaserver.model.request.DataSourceRequestVI;
import com.pxg.cloud.chpxgcloudqaserver.service.DataSourceService;
import com.pxg.cloud.chpxgcloudqaserver.util.ResultInfo;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 2020/3/27  16:25
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/27
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {
    private final Logger log = LoggerFactory.getLogger(DataSourceServiceImpl.class);

    @Autowired
    private DatasourceTableJpa datasourceTableJpa;

    @Autowired
    private ApiInfoJPA apiInfoJPA;
    /**
     * 验证数据源是否有效可连接到数据库
     * @param dataSourceRequestVI
     * @return
     */
    @Override
    public ResultInfo checkConntect(DataSourceRequestVI dataSourceRequestVI) {
        boolean resultBoolean = false;
        log.info(dataSourceRequestVI.toString());
        //获取数据库类型
        //数据库类型传递唯一的code
        DatabaseTypeEumn databaseTypeEumn = DatabaseTypeEumn.getDatabaseTypeEumnByCode(dataSourceRequestVI.getDatabaseType());
        if (databaseTypeEumn == null) {
            log.error("数据库类型不支持");
            return ResultInfo.error("数据库类型不支持");
        }
        //数据库类型
        // 初始化  BaseDatabaseMeta
        BaseDatabaseMeta baseDatabaseMeta = null;
        try {
            Class t = Class.forName(databaseTypeEumn.getClassMetaName());
            try {
                //java反射
                baseDatabaseMeta = (BaseDatabaseMeta) t.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                log.error(e.getMessage());
                //返回错误
                return ResultInfo.error(e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            //返回错误
            return ResultInfo.error(e.getMessage());
        }
        //设置数据源属性
        baseDatabaseMeta.setHost(dataSourceRequestVI.getDatabaseHost());
        baseDatabaseMeta.setPort(dataSourceRequestVI.getDatabasePort());
        baseDatabaseMeta.setDatabaseName(dataSourceRequestVI.getDatabaseName());
        baseDatabaseMeta.setUserName(dataSourceRequestVI.getUserName());
        baseDatabaseMeta.setPassword(dataSourceRequestVI.getUserPassword());
        log.info(baseDatabaseMeta.toString());
        // 数据库连接
        Connection connection = null;
        try {
            Logger log = LoggerFactory.getLogger(this.getClass());
            connection = Database.connect(baseDatabaseMeta, log);
            if (connection != null) {
                resultBoolean = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            //返回错误
            return ResultInfo.error(e.getMessage());
        }

        //关闭连接
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
            log.error(e.getMessage());
            //返回错误
            return ResultInfo.error(e.getMessage());
        }

        if (resultBoolean) {
            //连接成功返回
            return ResultInfo.ok("ok");
        }
        return ResultInfo.error("连接失败");

    }


    /**
     * 保存数据源
     * @param dataSourceRequestVI
     * @return
     */
    @Override
    public ResultInfo savaDataSource(DataSourceRequestVI dataSourceRequestVI) {
        //检查是否有效的连接
        ResultInfo resultInfo=checkConntect(dataSourceRequestVI);
        if (resultInfo.getCode()!=0){
            log.error("数据源配置不正确");
            return ResultInfo.wain("数据源配置不正确");
        }

        DatasourceTable datasourceTable=new DatasourceTable(
            dataSourceRequestVI.getDatabaseHost(),
            dataSourceRequestVI.getDatabasePort(),
            dataSourceRequestVI.getDatabaseName(),
            dataSourceRequestVI.getUserName(),
            dataSourceRequestVI.getUserPassword(),
                dataSourceRequestVI.getDatabaseType(),
                (long)0,
                new Date()
        );


        try {
            //查询数据源是否存在 如果已经存在了返回前端数据已经存在 v1.0版本 返回前端数据已存在
            //v2.0版本 返回已存在的数据源 且验证已存在的数据源是否有效
            // 如果后台数据无效则不处理 且更新数据为无效
            //如果有效 则 返回给前端  有效的数据 ，其他不做处理
            List<DatasourceTable> datasourceTables=datasourceTableJpa.getByDatabaseHostAndDatabasePortAndDatabaseNameAndStatus(
              datasourceTable.getDatabaseHost(),datasourceTable.getDatabasePort(),datasourceTable.getDatabaseName(),0
            );
            if (datasourceTables.size()>0){
                return ResultInfo.wain("数据已存在，请检查设置新的数据源");
            }else{
                datasourceTableJpa.saveAndFlush(datasourceTable);
            }
            return ResultInfo.ok("数据保存成功");
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return ResultInfo.error(e.getMessage());
        }
    }


    /**
     * v1.0.0 获取所有数据
     * 未加入分页和条件搜索
     * @return
     */
    @Override
    public ResultInfo getDataSource() {
        log.info("获取所有数据源");
        try {
            return  ResultInfo.ok(datasourceTableJpa.getByStatus(0));
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return ResultInfo.error(e.getMessage());
        }
    }

    /**
     * 保存接口配置
     * @param requestVi
     * @return
     */
    @Override
    public ResultInfo saveApiInfo( ApiConfigRequestVi requestVi) {
        log.info(requestVi.toString());
        ApiInfo apiInfo=new ApiInfo();
        String a="adassad";
        a.substring(1,1);
        //名称
        apiInfo.setUrlInfo(requestVi.getApiName());
        //地址
        apiInfo.setUrlPath(requestVi.getApiUrl());
        //类型
        apiInfo.setApiType(requestVi.getApiTypeCode());
        apiInfo.setNote(requestVi.toString());
        ApiSQLConfig apiSQLConfig=new ApiSQLConfig();
        apiSQLConfig.setSqlInfo(requestVi.getApiSQL());
        apiSQLConfig.setDataSourceId(requestVi.getDataSourceId());
        apiInfo.setApiConfig(apiSQLConfig.toString());
        apiInfo.setApiParam(requestVi.getParamList().toString());
        apiInfo.setStatus(0);
        apiInfo.setCreateTime(new Date());
        try {
            List<ApiInfo> apiInfos= apiInfoJPA.findByUrlPathAndStatus(requestVi.getApiUrl(),0);
            if (apiInfos.size()>0){
                return ResultInfo.wain("接口配置已存在请换个url");
            }
            apiInfoJPA.save(apiInfo);
            return ResultInfo.ok("成功");
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return ResultInfo.error(e.getMessage());
        }
    }
}
