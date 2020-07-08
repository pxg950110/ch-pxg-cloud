package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_BLOB_TRIGGERS
 * @author 
 */
@Data
public class QrtzBlobTriggers implements Serializable {
    private Integer id;

    // 计划名称
    private String schedName;


    private String triggerName;

    private String triggerGroup;

    private String blobData;

    private Integer qrtzTriggersId;

    private static final long serialVersionUID = 1L;
}