package ch.pxg.cloud.chpxgcloudwechat.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * wx_user_log
 * @author 
 */
@Data
public class WxUserLog implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 日志明细
     */
    private String logDetail;

    /**
     * 扩展字段
     */
    private String extend;

    /**
     * 服务日志创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}