package ch.pxg.cloud.chpxgcloudauthorserver.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="appuser.user_role")
public class UserRole {


  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
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


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
    return "UserRole{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", status=" + status +
            ", createTime=" + createTime +
            '}';
  }
}
