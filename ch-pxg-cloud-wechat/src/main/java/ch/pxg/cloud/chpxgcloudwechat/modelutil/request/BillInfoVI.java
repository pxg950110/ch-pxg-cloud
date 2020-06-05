package ch.pxg.cloud.chpxgcloudwechat.modelutil.request;

import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.DateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.UUID;

/**
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/12
 * @Version 1.0.0
 * @description </p>
 */
@ApiModel
public class BillInfoVI {

    @ApiModelProperty("消息id,UUID系统自动生成")
    String messageId;
    @ApiModelProperty("openId")
    String userId;
    @ApiModelProperty("年")
    String billYear;
    @ApiModelProperty("月")
    String billMonth;
    @ApiModelProperty("日")
    String billDay;
    @ApiModelProperty("账单类型")
    String billType;
    @ApiModelProperty("日期类型选择")
    DateEnum dateEnum;
    //是否需要子菜单
    @ApiModelProperty("是否需要具体账单")
    private boolean hasBillInfo;
    @ApiModelProperty("开始序列")
    private long startNumber;
    @ApiModelProperty("页码")
    private long pageSize;

    public BillInfoVI() {
        this.messageId= UUID.randomUUID().toString();
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public DateEnum getDateEnum() {
        return dateEnum;
    }

    public void setDateEnum(DateEnum dateEnum) {
        this.dateEnum = dateEnum;
    }

    public boolean isHasBillInfo() {
        return hasBillInfo;
    }

    public void setHasBillInfo(boolean hasBillInfo) {
        this.hasBillInfo = hasBillInfo;
    }

    public long getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(long startNumber) {
        this.startNumber = startNumber;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BillInfoVI{" +
                "messageId='" + messageId + '\'' +
                ", userId='" + userId + '\'' +
                ", billYear='" + billYear + '\'' +
                ", billMonth='" + billMonth + '\'' +
                ", billDay='" + billDay + '\'' +
                ", billType='" + billType + '\'' +
                ", dateEnum=" + dateEnum +
                '}';
    }
}
