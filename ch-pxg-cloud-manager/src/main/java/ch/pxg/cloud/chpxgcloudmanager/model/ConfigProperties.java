package ch.pxg.cloud.chpxgcloudmanager.model;

import java.io.Serializable;
import lombok.Data;

/**
 * config_properties
 * @author 
 */
@Data
public class ConfigProperties implements Serializable {
    private Integer id;

    private String propertyKey;

    private String propertyValue;

    private Integer serverId;

    private String des;

    public ConfigProperties(Integer id, String propertyKey, String propertyValue, Integer serverId, String des) {
        this.id = id;
        this.propertyKey = propertyKey;
        this.propertyValue = propertyValue;
        this.serverId = serverId;
        this.des = des;
    }

    public ConfigProperties(String propertyKey, Integer serverId) {
        this.propertyKey = propertyKey;
        this.serverId = serverId;
    }

    public ConfigProperties() {
    }

    private static final long serialVersionUID = 1L;
}