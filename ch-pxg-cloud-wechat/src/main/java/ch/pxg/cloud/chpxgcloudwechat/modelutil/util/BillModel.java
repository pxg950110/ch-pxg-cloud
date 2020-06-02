package ch.pxg.cloud.chpxgcloudwechat.modelutil.util;

import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;

import java.util.List;

/**
 * <p>
 * 2020/6/1  11:07
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/1
 * @Version 1.0.0
 * @description </p>
 * 账单
 */
public abstract class BillModel {


    //收入和支出
    private List<BillTypeAmount> amountList;
    //年账单 只能是月账单  子账单    年-->月  月-->日  日-->天
    private List<String> childDateList;
    private List<BillModel> chirdernList;

    //
    //具体的账单明细  只有日账单有明细
    private List<BillInfo> billInfoList;

    public List<BillTypeAmount> getAmountList() {
        return amountList;
    }

    public void setAmountList(List<BillTypeAmount> amountList) {
        this.amountList = amountList;
    }

    public List<BillModel> getChirdernList() {
        return chirdernList;
    }

    public List<String> getChildDateList() {
        return childDateList;
    }

    public void setChildDateList(List<String> childDateList) {
        this.childDateList = childDateList;
    }

    public void setChirdernList(List<BillModel> chirdernList) {
        this.chirdernList = chirdernList;
    }



    public List<BillInfo> getBillInfoList() {
        return billInfoList;
    }

    public void setBillInfoList(List<BillInfo> billInfoList) {
        this.billInfoList = billInfoList;
    }
}
