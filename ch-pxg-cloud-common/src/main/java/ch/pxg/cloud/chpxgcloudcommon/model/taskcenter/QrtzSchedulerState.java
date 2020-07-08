package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_SCHEDULER_STATE
 * @author 
 */
@Data
public class QrtzSchedulerState implements Serializable {
    private Integer id;

    private String schedName;

    private String instanceName;

    private Long lastCheckinTime;

    private Long checkinInterval;

    private static final long serialVersionUID = 1L;
}