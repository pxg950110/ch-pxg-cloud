package ch.pxg.cloud.chpxgcloudauthorserver.model;


import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "appuser.user_info")
public class UserInfo {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "user_name",nullable = false)
  private String userName;
  @Column(name = "user_password" ,nullable = false)
  private String userPassword;
  @Column(name = "create_time",nullable = false)
  private Date createTime;
  @Column(name = "status" ,columnDefinition = "0",nullable = false)
  private long status;



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "UserInfo{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", createTime=" + createTime +
            ", status=" + status +
            '}';
  }
}
