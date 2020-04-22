package ch.pxg.cloud.chpxgcloudcommon.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * <p>
 * 2020/3/1  18:08
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/1
 * @Version 1.0.0
 * @description </p>
 */
@Configuration
public class DataSourceConfig {

    @Value("${autoconfig.datasource.driverClassName}")
    private  String jdbcClass;
    @Value("${autoconfig.datasource.jdbcUrl}")
    private  String url;
    @Value("${autoconfig.datasource.username}")
    private  String userName;
    @Value("${autoconfig.datasource.password}")
    private  String password;

    @Bean("autoconfigDataSource")
    @Qualifier("autoconfigDataSource")
    @ConfigurationProperties(prefix = "autoconfig.datasource")
    @Primary
    public DataSource mysqlDataSource(){
//        DataSource dataSource=DataSourceBui
//                .create().build();

        return DataSourceBuilder.create().build();
    }

}
