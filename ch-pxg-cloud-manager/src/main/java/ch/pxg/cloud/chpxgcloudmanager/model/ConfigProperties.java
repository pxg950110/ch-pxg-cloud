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

    private static final long serialVersionUID = 1L;
}