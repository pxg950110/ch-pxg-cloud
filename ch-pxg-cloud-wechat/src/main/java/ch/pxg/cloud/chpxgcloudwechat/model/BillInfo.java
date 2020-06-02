package ch.pxg.cloud.chpxgcloudwechat.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * bill_info
 * @author 
 */
@Data
public class BillInfo implements Serializable {
    private Integer id;

    private String billType;

    private String billDate;

    private String billYear;

    private String billMonth;

    private String billDay;

    private Integer billTypeId;

    private String billTypeCode;

    private String billTypeName;

    private String billTypeImageurl;

    private Date createTime;

    private Integer status;

    private String extend;

    private String userId;

    private Date updateTime;

    private String note;

    private BigDecimal billNumber;



    /**
     * 唯一编号 v1.0版本未加入使用
     */
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
}