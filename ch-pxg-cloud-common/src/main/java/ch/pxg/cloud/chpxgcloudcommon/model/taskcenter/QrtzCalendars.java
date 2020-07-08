package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_CALENDARS
 * @author 
 */
@Data
public class QrtzCalendars implements Serializable {
    private Integer id;

    // 计划名称
    private String schedName;

    //
    private String calendarName;

    //
    private String calendar;

    private static final long serialVersionUID = 1L;
}