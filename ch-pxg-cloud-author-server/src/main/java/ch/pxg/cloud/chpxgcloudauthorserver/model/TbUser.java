package ch.pxg.cloud.chpxgcloudauthorserver.model;


import javax.persistence.*;
import java.util.Date;
@Table(name = "appuser.tb_user")
@Entity
public class TbUser {

  @GeneratedValue
  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "user_id")
  private long userId;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phone;
  @Column(name = "name")
  private String name;
  @Column(name = "detail_info")
  private String detailInfo;
  @Column(name = "status")
  private long status;
  @Column(name = "extend1")
  private String extend1;
  @Column(name = "extend2")
  private String extend2;
  @Column(name = "extend3")
  private String extend3;
  @Column(name = "extend4")
  private String extend4;
  @Column(name = "extend5")
  private String extend5;
  @Column(name = "extend6")
  private String extend6;
  @Column(name = "extend7")
  private String extend7;
  @Column(name = "extend8")
  private String extend8;
  @Column(name = "create_time")
  private Date createTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDetailInfo() {
    return detailInfo;
  }

  public void setDetailInfo(String detailInfo) {
    this.detailInfo = detailInfo;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getExtend1() {
    return extend1;
  }

  public void setExtend1(String extend1) {
    this.extend1 = extend1;
  }


  public String getExtend2() {
    return extend2;
  }

  public void setExtend2(String extend2) {
    this.extend2 = extend2;
  }


  public String getExtend3() {
    return extend3;
  }

  public void setExtend3(String extend3) {
    this.extend3 = extend3;
  }


  public String getExtend4() {
    return extend4;
  }

  public void setExtend4(String extend4) {
    this.extend4 = extend4;
  }


  public String getExtend5() {
    return extend5;
  }

  public void setExtend5(String extend5) {
    this.extend5 = extend5;
  }


  public String getExtend6() {
    return extend6;
  }

  public void setExtend6(String extend6) {
    this.extend6 = extend6;
  }


  public String getExtend7() {
    return extend7;
  }

  public void setExtend7(String extend7) {
    this.extend7 = extend7;
  }


  public String getExtend8() {
    return extend8;
  }

  public void setExtend8(String extend8) {
    this.extend8 = extend8;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "TbUser{" +
            "id=" + id +
            ", userId=" + userId +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", name='" + name + '\'' +
            ", detailInfo='" + detailInfo + '\'' +
            ", status=" + status +
            ", extend1='" + extend1 + '\'' +
            ", extend2='" + extend2 + '\'' +
            ", extend3='" + extend3 + '\'' +
            ", extend4='" + extend4 + '\'' +
            ", extend5='" + extend5 + '\'' +
            ", extend6='" + extend6 + '\'' +
            ", extend7='" + extend7 + '\'' +
            ", extend8='" + extend8 + '\'' +
            ", createTime=" + createTime +
            '}';
  }
}
