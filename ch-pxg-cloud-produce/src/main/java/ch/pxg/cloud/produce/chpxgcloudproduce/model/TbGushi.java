package ch.pxg.cloud.produce.chpxgcloudproduce.model;


import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "produce.tb_gushi")
public class TbGushi {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "gs_url")
  private String gsUrl;
  @Column(name = "status")
  private long status;
  @Column(name = "create_time")
  private Date createTime;
  @Column(name = "next_path")
  private  String nextPath;

  public TbGushi() {
  }

  public TbGushi(String gsUrl, long status, Date createTime, String nextPath) {
    this.gsUrl = gsUrl;
    this.status = status;
    this.createTime = createTime;
    this.nextPath = nextPath;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getGsUrl() {
    return gsUrl;
  }

  public void setGsUrl(String gsUrl) {
    this.gsUrl = gsUrl;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getNextPath() {
    return nextPath;
  }

  public void setNextPath(String nextPath) {
    this.nextPath = nextPath;
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }
}
