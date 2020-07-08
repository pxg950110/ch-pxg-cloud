package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_PAUSED_TRIGGER_GRPS
 * @author 
 */
@Data
public class QrtzPausedTriggerGrps implements Serializable {

    private Integer id;

    private String schedName;

    private String triggerGroup;

    private static final long serialVersionUID = 1L;
}