package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_SIMPLE_TRIGGERS
 * @author 
 */
@Data
public class QrtzSimpleTriggers implements Serializable {

    private Integer id;

    private String schedName;

    private String triggerName;    

    private String triggerGroup;

    private Long repeatCount;

    private Long repeatInterval;

    private Long timesTriggered;

    private Integer qrtzTriggersId;

    private static final long serialVersionUID = 1L;
}