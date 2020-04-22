package com.pxg.cloud.chpxgcloudqaserver.model;


import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "qaserver.api_info")
public class ApiInfo {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "url_path")
  private String urlPath;
  @Column(name = "url_info")
  private String urlInfo;
  @Column(name = "api_type")
  private String apiType;
  @Column(name = "api_config")
  private String apiConfig;
  @Column(name = "api_param")
  private String apiParam;
  @Column(name = "note")
  private String note;
  @Column(name = "status")
  private long status;
  @Column(name = "create_time")
  private Date createTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUrlPath() {
    return urlPath;
  }

  public void setUrlPath(String urlPath) {
    this.urlPath = urlPath;
  }


  public String getUrlInfo() {
    return urlInfo;
  }

  public void setUrlInfo(String urlInfo) {
    this.urlInfo = urlInfo;
  }


  public String getApiType() {
    return apiType;
  }

  public void setApiType(String apiType) {
    this.apiType = apiType;
  }


  public String getApiConfig() {
    return apiConfig;
  }

  public void setApiConfig(String apiConfig) {
    this.apiConfig = apiConfig;
  }


  public String getApiParam() {
    return apiParam;
  }

  public void setApiParam(String apiParam) {
    this.apiParam = apiParam;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
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

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }
}
