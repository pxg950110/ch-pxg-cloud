package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_FIRED_TRIGGERS
 * @author 
 */
@Data
public class QrtzFiredTriggers implements Serializable {
    private Integer id;

    private String schedName;

    private String entryId;

    private String triggerName;

    private String triggerGroup;

    private String instanceName;

    private Long firedTime;

    private Long schedTime;

    private Integer priority;

    private String state;

    private String jobName;

    private String jobGroup;

    private String isNonconcurrent;

    private String requestsRecovery;

    private static final long serialVersionUID = 1L;
}