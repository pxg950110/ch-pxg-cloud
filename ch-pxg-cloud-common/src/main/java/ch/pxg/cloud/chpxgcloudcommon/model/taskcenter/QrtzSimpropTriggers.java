package ch.pxg.cloud.chpxgcloudcommon.model.taskcenter;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * QRTZ_SIMPROP_TRIGGERS
 * @author 
 */
@Data
public class QrtzSimpropTriggers implements Serializable {
    private Integer id;

    private String schedName;

    private String triggerName;

    private String triggerGroup;

    private String strProp1;

    private String strProp2;

    private String strProp3;

    private Integer intProp1;

    private Integer intProp2;

    private Long longProp1;

    private Long longProp2;

    private BigDecimal decProp1;

    private BigDecimal decProp2;

    private String boolProp1;

    private String boolProp2;

    private Integer qrtzTriggersId;

    private static final long serialVersionUID = 1L;
}