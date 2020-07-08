package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_TRIGGERS
 * @author 
 */
@Data
public class QrtzTriggers implements Serializable {
    //id
    private Integer id;
    //计划名称
    private String schedName;
    // 任务key
    private String triggerName;
    // 分组名称
    private String triggerGroup;
    // 任务名称
    private String jobName;
    // 任务分组
    private String jobGroup;
    // 描述
    private String description;
    //  接下来执行时间
    private Long nextFireTime;
    //  上一次执行时间
    private Long prevFireTime;
    //优先执行
    private Integer priority;
    // 状态
    private String triggerState;

    // 类型
    private String triggerType;

    // 开始时间
    private Long startTime;

    // 结束时间
    private Long endTime;

    //
    private String calendarName;

    //
    private Short misfireInstr;

    //  任务数据
    private String jobData;

    // 任务明细id
    private Integer qrtzJobDetailsId;

    private static final long serialVersionUID = 1L;
}