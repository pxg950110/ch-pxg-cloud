package ch.pxg.cloud.chpxgcloudconfig.config;

import ch.pxg.cloud.chpxgcloudconfig.service.ConfigRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 2020/3/1  18:42
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
public class DatabasesEnvironmentRepository implements
        EnvironmentRepository {

    @Autowired
    private ConfigRepositoryService configRepositoryService;
    @Override
    public Environment findOne(String application, String profile, String label) {
        //如果应用 为空
        if (StringUtils.isEmpty(application) || StringUtils.isEmpty(profile) )
            return null;
       return configRepositoryService.findByApplicationAndProfileAndLabel(
               application, profile, label);
    }
}
