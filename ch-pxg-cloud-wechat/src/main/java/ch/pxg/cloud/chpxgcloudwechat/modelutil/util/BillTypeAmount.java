package ch.pxg.cloud.chpxgcloudwechat.modelutil.util;

import java.util.List;

/**
 * <p>
 * 2020/6/1  11:20
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/1
 * @Version 1.0.0
 * @description </p>
 */
public class BillTypeAmount {
    private String billType;
    private String sumAmount;
    private String billYear;
    private String billMonth;
    private String billDay;
    // 下面的 年-->月   月-->天  天 -->null
    private List<String> chirlList;


    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    @Override
    public String toString() {
        return "BillTypeAmount{" +
                "billType='" + billType + '\'' +
                ", sumAmount='" + sumAmount + '\'' +
                ", billYear='" + billYear + '\'' +
                ", billMonth='" + billMonth + '\'' +
                ", billDay='" + billDay + '\'' +
                '}';
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
}
