package ch.pxg.cloud.chpxgcloudcommon.model;


import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "appuser.email_code")
public class EmailCode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name = "msg_id")
  private String msgId;
  @Column(name = "msg_detail")
  private String msgDetail;
  @Column(name = "email_url")
  private String emailUrl;
  @Column(name = "emial_code")
  private String emialCode;
  @Column(name = "create_time")
  private Date createTime;
  @Column(name = "status")
  private long status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

  /**
   * 重写toString方法返回 json字符
   * @return
   */
  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }
}
