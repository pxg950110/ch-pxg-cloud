package ch.pxg.cloud.produce.chpxgcloudproduce.model;


import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produce.tb_gushi_url")
public class TbGushiUrl {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "gs_title")
  private String gsTitle;
  @Column(name = "gs_parent_id")
  private long gsParentId;
  @Column(name = "gs_path")
  private String gsPath;
  @Column(name = "gs_content")
  private String gsContent;
  @Column(name = "gs_content1")
  private String gsContent1;
  @Column(name = "gs_content2")
  private String gsContent2;
  @Column(name = "gs_content3")
  private String gsContent3;
  @Column(name = "gs_content4")
  private String gsContent4;
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


  public String getGsTitle() {
    return gsTitle;
  }

  public void setGsTitle(String gsTitle) {
    this.gsTitle = gsTitle;
  }


  public long getGsParentId() {
    return gsParentId;
  }

  public void setGsParentId(long gsParentId) {
    this.gsParentId = gsParentId;
  }


  public String getGsPath() {
    return gsPath;
  }

  public void setGsPath(String gsPath) {
    this.gsPath = gsPath;
  }


  public String getGsContent() {
    return gsContent;
  }

  public void setGsContent(String gsContent) {
    this.gsContent = gsContent;
  }


  public String getGsContent1() {
    return gsContent1;
  }

  public void setGsContent1(String gsContent1) {
    this.gsContent1 = gsContent1;
  }


  public String getGsContent2() {
    return gsContent2;
  }

  public void setGsContent2(String gsContent2) {
    this.gsContent2 = gsContent2;
  }


  public String getGsContent3() {
    return gsContent3;
  }

  public void setGsContent3(String gsContent3) {
    this.gsContent3 = gsContent3;
  }


  public String getGsContent4() {
    return gsContent4;
  }

  public void setGsContent4(String gsContent4) {
    this.gsContent4 = gsContent4;
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
