package ch.pxg.cloud.chpxgcloudconfig.service;

import ch.pxg.cloud.chpxgcloudconfig.dao.ConfigPropertiseRepository;
import ch.pxg.cloud.chpxgcloudconfig.dao.SystemConfigDbRepository;
import ch.pxg.cloud.chpxgcloudconfig.model.ConfigProperties;
import ch.pxg.cloud.chpxgcloudconfig.model.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pxg
 * 配置查询服务
 */
@Service
public class ConfigRepositoryService {
    private final Logger log= LoggerFactory.getLogger(ConfigRepositoryService.class);
    @Autowired
    private SystemConfigDbRepository systemConfigDbRepository;

    @Autowired
    private ConfigPropertiseRepository configPropertiseRepository;

    public Environment findByApplicationAndProfileAndLabel(String application, String profile, String label) {
        SystemConfig systemConfig=systemConfigDbRepository.getByServerNameAndProfileAndLabel(
                application,profile,label
        );

        Environment environment=new Environment(application,profile,label,null,null);
        //serverId为0 默认为公共配置
        List<ConfigProperties> configProperties=configPropertiseRepository.getAllByServerIdOrServerId(systemConfig.getId(),0);
        List<PropertySource> propertySources = new ArrayList<>();
        configProperties.forEach(
                configProperties1 -> {
                    Map<String,String> map=new HashMap<>();
                    log.info(configProperties1.toString());
                    map.put(configProperties1.getPropertyKey(),configProperties1.getPropertyValue());
                    PropertySource propertySource=new PropertySource(
                            "配置信息",map
                    );
                }
        );
        environment.addAll(propertySources);
        return environment;
    }
}
