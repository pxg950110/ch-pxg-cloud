package ch.pxg.cloud.chpxgcloudwechat.server;

import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.model.BillInfoVI;
import ch.pxg.cloud.chpxgcloudwechat.util.ResultInfo;

public interface WxService {

    /**
     * 记一笔账单
     * @param billInfo
     * @return
     */
    public ResultInfo addBillInfo(BillInfo billInfo);


    /**
     * 获取所有类别
     * @return
     */
    public ResultInfo getBillTypeList(String openId);
}
