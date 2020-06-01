package ch.pxg.cloud.chpxgcloudwechat.server;

import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.request.BillInfoVI;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.BillModel;
import ch.pxg.cloud.chpxgcloudwechat.util.ResultInfo;
import com.pxg.clould.chpxgclouldutil.CommonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WxService {

    /**
     * 记一笔账单
     * @param billInfo
     * @return
     */
    ResultInfo addBillInfo(BillInfo billInfo, HttpServletRequest request, HttpServletResponse response);


    void test();
    /**
     * 获取所有类别
     * @return
     */
    ResultInfo getBillTypeList(String openId, HttpServletRequest request, HttpServletResponse response);

    CommonResult getBillInfo(BillInfoVI billInfoVI, HttpServletRequest request, HttpServletResponse response);

    CommonResult<BillModel> getBillModelInfo(BillInfoVI billInfoVI, HttpServletRequest request, HttpServletResponse response);
}
