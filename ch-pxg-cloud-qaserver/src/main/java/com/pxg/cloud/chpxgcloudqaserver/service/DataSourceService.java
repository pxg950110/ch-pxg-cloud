package com.pxg.cloud.chpxgcloudqaserver.service;

import com.pxg.cloud.chpxgcloudqaserver.model.request.ApiConfigRequestVi;
import com.pxg.cloud.chpxgcloudqaserver.model.request.DataSourceRequestVI;
import com.pxg.cloud.chpxgcloudqaserver.util.ResultInfo;

/**
 * 数据源管理服务
 */
public interface DataSourceService{

    /**
     * 验证数据源是否有效可连接到数据库
     * @param dataSourceRequestVI
     * @return
     */
    public ResultInfo checkConntect(DataSourceRequestVI dataSourceRequestVI);


    /**
     * 保存数据源
     * @param dataSourceRequestVI
     * @return
     */
    public  ResultInfo savaDataSource(DataSourceRequestVI dataSourceRequestVI);


    /**
     * v1.0.0获取所有数据 未加入分页和条件搜索
     * @return
     */
    public ResultInfo getDataSource();

    /**
     * 保存接口配置
     * @param requestVi
     * @return
     */
    public ResultInfo saveApiInfo(ApiConfigRequestVi requestVi);
}
