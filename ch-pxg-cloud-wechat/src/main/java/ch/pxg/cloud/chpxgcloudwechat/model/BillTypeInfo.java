package ch.pxg.cloud.chpxgcloudwechat.model;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "wxapp.bill_type_info")
public class BillTypeInfo {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;
  @Column(name = "code")
  private String code;
  @Column(name = "name")
  private String name;
  @Column(name = "image_url")
  private String imageUrl;
  @Column(name = "image_name")
  private String imageName;
  @Column(name = "note")
  private String note;
  @Column(name = "create_time")
  private Date createTime;
  @Column(name = "image_type")
  private String imageType;
  @Column(name = "user_id")
  private String userId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getImageType() {
    return imageType;
  }

  public void setImageType(String imageType) {
    this.imageType = imageType;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "BillTypeInfo{" +
            "id=" + id +
            ", code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", imageName='" + imageName + '\'' +
            ", note='" + note + '\'' +
            ", createTime=" + createTime +
            ", imageType='" + imageType + '\'' +
            ", userId='" + userId + '\'' +
            '}';
  }
}
