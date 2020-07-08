package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_JOB_DETAILS
 * @author 
 */
@Data
public class QrtzJobDetails implements Serializable {
    private Integer id;

    private String schedName;

    private String jobName;

    private String jobGroup;

    private String description;

    private String jobClassName;

    private String isDurable;

    private String isNonconcurrent;

    private String isUpdateData;

    private String requestsRecovery;

    private String jobData;

    private static final long serialVersionUID = 1L;
}