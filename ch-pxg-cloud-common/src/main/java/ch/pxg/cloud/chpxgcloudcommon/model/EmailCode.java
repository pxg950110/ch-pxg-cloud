package ch.pxg.cloud.chpxgcloudcommon.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * email_code
 * @author 
 */
@Data
public class EmailCode implements Serializable {

    private Integer id;

    private String msgId;

    private String msgDetail;

    private String emailUrl;

    private String emialCode;

    private Date createTime;

    private Integer status;

    private static final long serialVersionUID = 1L;

}