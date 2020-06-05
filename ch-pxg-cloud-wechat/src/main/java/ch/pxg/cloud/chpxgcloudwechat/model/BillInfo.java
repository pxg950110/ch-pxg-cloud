package ch.pxg.cloud.chpxgcloudwechat.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * bill_info
 * @author 
 */
@Data
public class BillInfo implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("账单类别")
    private String billType;

    @ApiModelProperty("账单日期")
    private String billDate;
    @ApiModelProperty("账单日期-年")
    private String billYear;
    @ApiModelProperty("账单日期-月")
    private String billMonth;
    @ApiModelProperty("账单日期-日")
    private String billDay;

    @ApiModelProperty("账单类型-id")
    private Integer billTypeId;

    @ApiModelProperty("账单类型-代码")
    private String billTypeCode;
    @ApiModelProperty("账单类型-名称")
    private String billTypeName;
    @ApiModelProperty("账单类型的图标路径")
    private String billTypeImageurl;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态  0有效 2 无效")
    private Integer status;

    @ApiModelProperty("扩展字段")
    private String extend;

    @ApiModelProperty("openId")
    private String userId;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("具体金额")
    private BigDecimal billNumber;



    /**
     * 唯一编号 v1.0版本未加入使用
     */
    @ApiModelProperty("账单唯一编号")
    private String billNo;

    private static final long serialVersionUID = 1L;

    public BillInfo() {
    }

    public BillInfo(String billYear, String billMonth, String billDay, Integer status, String userId) {
        this.billYear = billYear;
        this.billMonth = billMonth;
        this.billDay = billDay;
        this.status = status;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BillInfo other = (BillInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getBillYear() == null ? other.getBillYear() == null : this.getBillYear().equals(other.getBillYear()))
            && (this.getBillMonth() == null ? other.getBillMonth() == null : this.getBillMonth().equals(other.getBillMonth()))
            && (this.getBillDay() == null ? other.getBillDay() == null : this.getBillDay().equals(other.getBillDay()))
            && (this.getBillTypeId() == null ? other.getBillTypeId() == null : this.getBillTypeId().equals(other.getBillTypeId()))
            && (this.getBillTypeCode() == null ? other.getBillTypeCode() == null : this.getBillTypeCode().equals(other.getBillTypeCode()))
            && (this.getBillTypeName() == null ? other.getBillTypeName() == null : this.getBillTypeName().equals(other.getBillTypeName()))
            && (this.getBillTypeImageurl() == null ? other.getBillTypeImageurl() == null : this.getBillTypeImageurl().equals(other.getBillTypeImageurl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getExtend() == null ? other.getExtend() == null : this.getExtend().equals(other.getExtend()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getBillNumber() == null ? other.getBillNumber() == null : this.getBillNumber().equals(other.getBillNumber()))
            && (this.getBillNo() == null ? other.getBillNo() == null : this.getBillNo().equals(other.getBillNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getBillYear() == null) ? 0 : getBillYear().hashCode());
        result = prime * result + ((getBillMonth() == null) ? 0 : getBillMonth().hashCode());
        result = prime * result + ((getBillDay() == null) ? 0 : getBillDay().hashCode());
        result = prime * result + ((getBillTypeId() == null) ? 0 : getBillTypeId().hashCode());
        result = prime * result + ((getBillTypeCode() == null) ? 0 : getBillTypeCode().hashCode());
        result = prime * result + ((getBillTypeName() == null) ? 0 : getBillTypeName().hashCode());
        result = prime * result + ((getBillTypeImageurl() == null) ? 0 : getBillTypeImageurl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getExtend() == null) ? 0 : getExtend().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getBillNumber() == null) ? 0 : getBillNumber().hashCode());
        result = prime * result + ((getBillNo() == null) ? 0 : getBillNo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", billType=").append(billType);
        sb.append(", billDate=").append(billDate);
        sb.append(", billYear=").append(billYear);
        sb.append(", billMonth=").append(billMonth);
        sb.append(", billDay=").append(billDay);
        sb.append(", billTypeId=").append(billTypeId);
        sb.append(", billTypeCode=").append(billTypeCode);
        sb.append(", billTypeName=").append(billTypeName);
        sb.append(", billTypeImageurl=").append(billTypeImageurl);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", extend=").append(extend);
        sb.append(", userId=").append(userId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", note=").append(note);
        sb.append(", billNumber=").append(billNumber);
        sb.append(", billNo=").append(billNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getBillTypeId() {
        return billTypeId;
    }

    public void setBillTypeId(Integer billTypeId) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public BigDecimal getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(BigDecimal billNumber) {
        this.billNumber = billNumber;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
}