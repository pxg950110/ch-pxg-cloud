package ch.pxg.cloud.chpxgcloudwechat.server;

import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.model.BillInfoVI;
import ch.pxg.cloud.chpxgcloudwechat.util.ResultInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WxService {

    /**
     * 记一笔账单
     * @param billInfo
     * @return
     */
    ResultInfo addBillInfo(BillInfo billInfo, HttpServletRequest request, HttpServletResponse response);


    /**
     * 获取所有类别
     * @return
     */
    ResultInfo getBillTypeList(String openId, HttpServletRequest request, HttpServletResponse response);
}
