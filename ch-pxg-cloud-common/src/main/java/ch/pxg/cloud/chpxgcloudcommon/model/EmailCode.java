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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgDetail() {
        return msgDetail;
    }

    public void setMsgDetail(String msgDetail) {
        this.msgDetail = msgDetail;
    }

    public String getEmailUrl() {
        return emailUrl;
    }

    public void setEmailUrl(String emailUrl) {
        this.emailUrl = emailUrl;
    }

    public String getEmialCode() {
        return emialCode;
    }

    public void setEmialCode(String emialCode) {
        this.emialCode = emialCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}