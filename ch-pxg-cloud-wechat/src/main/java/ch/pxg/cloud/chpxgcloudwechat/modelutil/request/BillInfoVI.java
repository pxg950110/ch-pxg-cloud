package ch.pxg.cloud.chpxgcloudwechat.modelutil.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
}
