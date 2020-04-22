package com.pxg.cloud.chpxgcloudqaserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.pxg.cloud.chpxgcloudqaserver.apiconfig.ApiSQLConfig;
import com.pxg.cloud.chpxgcloudqaserver.dao.ApiInfoJPA;
import com.pxg.cloud.chpxgcloudqaserver.dao.DatasourceTableJpa;
import com.pxg.cloud.chpxgcloudqaserver.database.BaseDatabaseMeta;
import com.pxg.cloud.chpxgcloudqaserver.database.Database;
import com.pxg.cloud.chpxgcloudqaserver.database.DatabaseTypeEumn;
import com.pxg.cloud.chpxgcloudqaserver.model.ApiInfo;
import com.pxg.cloud.chpxgcloudqaserver.model.DatasourceTable;
import com.pxg.cloud.chpxgcloudqaserver.model.request.ApiCommon;
import com.pxg.cloud.chpxgcloudqaserver.model.request.ApiCommonRequestVI;
import com.pxg.cloud.chpxgcloudqaserver.model.request.ParamList;
import com.pxg.cloud.chpxgcloudqaserver.service.CommonApiService;
import com.pxg.cloud.chpxgcloudqaserver.util.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 2020/4/3  11:17
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/3
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class CommonApiServiceImpl implements CommonApiService {
    @Autowired
    private ApiInfoJPA apiInfoJPA;

    @Autowired
    private DatasourceTableJpa datasourceTableJpa;

    private final Logger log = LoggerFactory.getLogger(CommonApiServiceImpl.class);




    @Override
    public ResultInfo getCommonApiResult(String url, ApiCommonRequestVI apiCommonRequestVI) {
        log.info("请求接口: api/{}", url);
        log.info("请求参数:{}", JSON.toJSONString(apiCommonRequestVI));
        // 获取接口配置信息
        ApiInfo apiInfo = null;
        try {
            apiInfo = apiInfoJPA.findByUrlPathAndStatus(url, 0).get(0);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return ResultInfo.error(e.getMessage());
        }
        log.info(apiInfo.toString());
        ApiSQLConfig apiSQLConfig = toApiSqlCofig(apiInfo.getApiConfig());
        log.info(apiSQLConfig.toString());
        List<ParamList> paramLists = toParamList(apiInfo.getApiParam());
        log.info(paramLists.toString());
        //生成sql语句
        String sql = apiSQLConfig.getSqlInfo();
        //循环赋值
        for (ParamList paramList : paramLists) {
            for (ApiCommon apiCommon : apiCommonRequestVI.getApiCommonList()) {
//                log.info();
                if (apiCommon.getApiParamCode().equals(paramList.getParamData())) {
                    sql = sql.replace(paramList.getParamIndex(), apiCommon.getApiParamValue());
                    log.info(sql);
                }
            }
        }
        if (sql.indexOf("$") != -1) {
            return ResultInfo.error("参数传递错误");
        }
        log.info("执行的sql:{}",sql);
        //
        DatasourceTable datasourceTable = datasourceTableJpa.getByIdAndStatus(Long.parseLong(apiSQLConfig.getDataSourceId()), 0);

        List<Map<Object, Object>> maps = getApiResult(sql, datasourceTable);
        if (maps.size() <= 0) {
            return ResultInfo.wain(null);
        } else if (maps.size() == 1) {
            return ResultInfo.ok(maps.get(0));
        } else {
            return ResultInfo.ok(maps);
        }
    }


    public static List<ParamList> toParamList(String paramStr) {
        try {
            List<Map<String, Object>> maps = (List<Map<String, Object>>) JSON.parse(paramStr);
            List<ParamList> paramLists = new ArrayList<>();
            maps.forEach(
                    e -> {
                        ParamList paramList = new ParamList();
                        paramList.setParamIndex((String) e.get("paramIndex"));
                        paramList.setParamData((String) e.get("paramData"));
                        paramLists.add(paramList);
                    }
            );
            return paramLists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ApiSQLConfig toApiSqlCofig(String apiconfigStr) {
        try {
            Map<String, Object> map = (Map<String, Object>) JSON.parse(apiconfigStr);
            ApiSQLConfig apiSQLConfig = new ApiSQLConfig();
            apiSQLConfig.setDataSourceId((String) map.get("dataSourceId"));
            apiSQLConfig.setSqlInfo((String) map.get("sqlInfo"));
            return apiSQLConfig;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //通过 sql和数据库id查询出数据
    public static List<Map<Object, Object>> getApiResult(String sql, DatasourceTable datasourceTable) {
        Logger log = LoggerFactory.getLogger(CommonApiServiceImpl.class);
        List<Map<Object, Object>> maps = new ArrayList<>();
        //查询 数据库配置
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet =null;
        try {
            DatabaseTypeEumn databaseTypeEumn = DatabaseTypeEumn.getDatabaseTypeEumnByCode(
                    datasourceTable.getDatabaseType()
            );
            Class t = Class.forName(databaseTypeEumn.getClassMetaName());
            BaseDatabaseMeta baseDatabaseMeta = (BaseDatabaseMeta) t.newInstance();
            //
            baseDatabaseMeta.setHost(datasourceTable.getDatabaseHost());
            baseDatabaseMeta.setPort(datasourceTable.getDatabasePort());
            baseDatabaseMeta.setDatabaseName(datasourceTable.getDatabaseName());
            baseDatabaseMeta.setUserName(datasourceTable.getUserName());
            baseDatabaseMeta.setPassword(datasourceTable.getUserPassword());
            log.info("执行sql:{}", sql);
            connection = Database.connect(baseDatabaseMeta, log);
            statement = connection.createStatement();
             resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Map<Object, Object> map = new HashMap<>();
                // 单列
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    map.put(resultSetMetaData.getColumnLabel(i), resultSet.getString(i));
                }
                maps.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        //关闭连接
//        assert statement != null;
        try {
            if (resultSet!=null)
                resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maps;
    }
}