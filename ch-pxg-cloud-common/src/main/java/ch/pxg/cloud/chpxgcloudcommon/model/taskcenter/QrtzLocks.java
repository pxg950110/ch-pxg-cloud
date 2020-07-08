package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import lombok.Data;

/**
 * QRTZ_LOCKS
 * @author 
 */
@Data
public class QrtzLocks implements Serializable {
    private Integer id;

    private String schedName;

    private String lockName;

    private static final long serialVersionUID = 1L;
}