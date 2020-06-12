package ch.pxg.cloud.chpxgcloudmanager.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * system_config
 * @author 
 */
@Data
public class SystemConfig implements Serializable {
    private Integer id;

    private String serverName;

    private String serverInfo;

    private String profile;

    private String label;

    private String version;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}