package ch.pxg.cloud.chpxgcloudconfig.model;

import javax.persistence.*;

@Entity
@Table(name = "appsystem.config_properties")
public class ConfigProperties {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;
  @Column(name = "property_key")
  private String propertyKey;
  @Column(name = "property_value")
  private String propertyValue;
  @Column(name = "server_id")
  private long serverId;
  @Column(name = "des")
  private String des;

  @Column(name = "is_deleted")
  private Integer isDeleted;

  public Integer getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getPropertyKey() {
    return propertyKey;
  }

  public void setPropertyKey(String propertyKey) {
    this.propertyKey = propertyKey;
  }


  public String getPropertyValue() {
    return propertyValue;
  }

  public void setPropertyValue(String propertyValue) {
    this.propertyValue = propertyValue;
  }


  public long getServerId() {
    return serverId;
  }

  public void setServerId(long serverId) {
    this.serverId = serverId;
  }


  public String getDes() {
    return des;
  }

  public void setDes(String des) {
    this.des = des;
  }

  @Override
  public String toString() {
    return "ConfigProperties{" +
            "id=" + id +
            ", propertyKey='" + propertyKey + '\'' +
            ", propertyValue='" + propertyValue + '\'' +
            ", serverId=" + serverId +
            ", des='" + des + '\'' +
            '}';
  }
}
