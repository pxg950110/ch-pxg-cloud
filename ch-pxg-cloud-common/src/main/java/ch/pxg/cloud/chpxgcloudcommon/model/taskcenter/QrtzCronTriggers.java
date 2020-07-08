package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_CRON_TRIGGERS
 * @author    ch_pxg
 * cron表达式
 */
@Data
public class QrtzCronTriggers implements Serializable {
    private Integer id;

    private String schedName;

    private String triggerName;

    private String triggerGroup;

    private String cronExpression;

    private String timeZoneId;

    private Integer qrtzTriggersId;

    private static final long serialVersionUID = 1L;
}