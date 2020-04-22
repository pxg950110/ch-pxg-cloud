package com.pxg.cloud.chpxgcloudqaserver.dao;

import com.pxg.cloud.chpxgcloudqaserver.model.DatasourceTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <p>
 * 2020/3/26  18:47
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
public interface DatasourceTableJpa extends JpaRepository<DatasourceTable,Integer> {

    List<DatasourceTable> getByDatabaseHostAndDatabasePortAndDatabaseNameAndStatus(String databaseHost, String databasePort, String databaseName, long status);

    /**
     * 数据源密码不提供给前台
     * @param status
     * @return
     */
    @Query(value = "select  id, database_host, database_port, database_name, user_name, null as user_password, database_type, status, create_time from qaserver.datasource_table where status =:status"
    ,nativeQuery = true)
    List<DatasourceTable> getByStatus(long status);

    DatasourceTable getByIdAndStatus(long id, long status);
}
