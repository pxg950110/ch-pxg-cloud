package com.pxg.cloud.chpxgcloudqaserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * <p>
 * 2020/3/1  18:11
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
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {
                "com.pxg.cloud.chpxgcloudqaserver.dao"
        },
        transactionManagerRef = "autoconfigTransactionManager",
        entityManagerFactoryRef = "autoconfigManagerFactory"
)
public class SystemDatabaseConfig {
    @Autowired(required =false)
    private JpaProperties jpaProperties;
    //
    @Autowired
    @Qualifier("autoconfigDataSource")
    private DataSource systemconfigDataSource;
    @Bean(name = "autoconfigManager")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return entityManagerFactory(builder).getObject().createEntityManager();
    }
    //
    @Primary
    @Bean(name = "autoconfigManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(EntityManagerFactoryBuilder builder){
//        Map<String,Object> properties=hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),new HibernateSettings());

        return builder.dataSource(systemconfigDataSource)
                .properties(jpaProperties.getProperties())
                .packages( "com.pxg.cloud.chpxgcloudqaserver.model")
                .persistenceUnit("persistenceUnit")
                .build();
    }
    @Primary
    @Bean(name = "autoconfigTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }
}
