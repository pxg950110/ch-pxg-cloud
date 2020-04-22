package com.pxg.cloud.chpxgcloudqaserver.model;


import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "qaserver.datasource_table")
public class DatasourceTable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "database_host")
  private String databaseHost;
  @Column(name = "database_port")
  private String databasePort;
  @Column(name = "database_name")
  private String databaseName;
  @Column(name = "user_name")
  private String userName;
  @Column(name = "user_password")
  private String userPassword;
  @Column(name = "database_type")
  private String databaseType;
  @Column(name = "status")
  private long status;
  @Column(name = "create_time")
  private Date createTime;


  public DatasourceTable() {
  }

  public DatasourceTable(String databaseHost, String databasePort, String databaseName, String userName, String userPassword, String databaseType, long status, Date createTime) {
    this.databaseHost = databaseHost;
    this.databasePort = databasePort;
    this.databaseName = databaseName;
    this.userName = userName;
    this.userPassword = userPassword;
    this.databaseType = databaseType;
    this.status = status;
    this.createTime = createTime;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDatabaseHost() {
    return databaseHost;
  }

  public void setDatabaseHost(String databaseHost) {
    this.databaseHost = databaseHost;
  }


  public String getDatabasePort() {
    return databasePort;
  }

  public void setDatabasePort(String databasePort) {
    this.databasePort = databasePort;
  }


  public String getDatabaseName() {
    return databaseName;
  }

  public void setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getDatabaseType() {
    return databaseType;
  }

  public void setDatabaseType(String databaseType) {
    this.databaseType = databaseType;
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
