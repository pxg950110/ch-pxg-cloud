package ch.pxg.cloud.chpxgcloudwechat.model;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "wxapp.bill_info")
public class BillInfo {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;
  @Column(name = "bill_type")
  private String billType;
  @Column(name = "bill_date")
  private String billDate;
  @Column(name = "bill_year")
  private String billYear;
  @Column(name = "bill_month")
  private String billMonth;
  @Column(name = "bill_day")
  private String billDay;
  @Column(name = "bill_type_id")
  private long billTypeId;
  @Column(name = "bill_type_code")
  private String billTypeCode;
  @Column(name = "bill_type_name")
  private String billTypeName;
  @Column(name = "bill_type_imageurl")
  private String billTypeImageurl;
  @Column(name = "create_time")
  private Date createTime;
  @Column(name = "status")
  private long status;
  @Column(name = "extend")
  private String extend;
  @Column(name = "user_id")
  private String userId;
  @Column(name = "update_time")
  private Date updateTime;
  @Column(name = "note")
  private String note;
  @Column(name = "bill_number")
  private double billNumber;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getBillType() {
    return billType;
  }

  public void setBillType(String billType) {
    this.billType = billType;
  }


  public String getBillDate() {
    return billDate;
  }

  public void setBillDate(String billDate) {
    this.billDate = billDate;
  }


  public String getBillYear() {
    return billYear;
  }

  public void setBillYear(String billYear) {
    this.billYear = billYear;
  }


  public String getBillMonth() {
    return billMonth;
  }

  public void setBillMonth(String billMonth) {
    this.billMonth = billMonth;
  }


  public String getBillDay() {
    return billDay;
  }

  public void setBillDay(String billDay) {
    this.billDay = billDay;
  }


  public long getBillTypeId() {
    return billTypeId;
  }

  public void setBillTypeId(long billTypeId) {
    this.billTypeId = billTypeId;
  }


  public String getBillTypeCode() {
    return billTypeCode;
  }

  public void setBillTypeCode(String billTypeCode) {
    this.billTypeCode = billTypeCode;
  }


  public String getBillTypeName() {
    return billTypeName;
  }

  public void setBillTypeName(String billTypeName) {
    this.billTypeName = billTypeName;
  }


  public String getBillTypeImageurl() {
    return billTypeImageurl;
  }

  public void setBillTypeImageurl(String billTypeImageurl) {
    this.billTypeImageurl = billTypeImageurl;
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


  public String getExtend() {
    return extend;
  }

  public void setExtend(String extend) {
    this.extend = extend;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }


  public double getBillNumber() {
    return billNumber;
  }

  public void setBillNumber(double billNumber) {
    this.billNumber = billNumber;
  }


  @Override
  public String toString() {
    return "BillInfo{" +
            "id=" + id +
            ", billType='" + billType + '\'' +
            ", billDate='" + billDate + '\'' +
            ", billYear='" + billYear + '\'' +
            ", billMonth='" + billMonth + '\'' +
            ", billDay='" + billDay + '\'' +
            ", billTypeId=" + billTypeId +
            ", billTypeCode='" + billTypeCode + '\'' +
            ", billTypeName='" + billTypeName + '\'' +
            ", billTypeImageurl='" + billTypeImageurl + '\'' +
            ", createTime=" + createTime +
            ", status=" + status +
            ", extend='" + extend + '\'' +
            ", userId='" + userId + '\'' +
            ", updateTime=" + updateTime +
            ", note='" + note + '\'' +
            ", billNumber=" + billNumber +
            '}';
  }
}
