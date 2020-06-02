package ch.pxg.cloud.chpxgcloudwechat.modelutil.util;

/**
 * <p>
 * 2020/6/1  11:30
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/1
 * @Version 1.0.0
 * @description </p>
 */
public class BillRequestModel {

    //年
    private String billYear;
    //月
    private String billMonth;
    //日
    private String billDay;
    //日期类型
    private DateEnum dateEnum;

    private String userId;


    public BillRequestModel() {
    }

    public BillRequestModel(String billYear, String billMonth, String billDay, DateEnum dateEnum, String userId) {
        this.billYear = billYear;
        this.billMonth = billMonth;
        this.billDay = billDay;
        this.dateEnum = dateEnum;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public DateEnum getDateEnum() {
        return dateEnum;
    }

    public void setDateEnum(DateEnum dateEnum) {
        this.dateEnum = dateEnum;
    }
}

