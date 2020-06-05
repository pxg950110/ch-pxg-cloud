package ch.pxg.cloud.chpxgcloudwechat.server;

import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.request.BillInfoVI;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.BillModel;
import ch.pxg.cloud.chpxgcloudwechat.util.ResultInfo;
import ch.pxg.cloud.chpxgcloudwechat.util.CommonResult;
import org.springframework.data.repository.query.Param;

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

    CommonResult getBillInfo(BillInfoVI billInfoVI, HttpServletRequest request, HttpServletResponse response);

    CommonResult<BillModel> getBillModelInfo(BillInfoVI billInfoVI, HttpServletRequest request, HttpServletResponse response);

    CommonResult<String> getMaxBillDateInfo(@Param("userId") String userId , HttpServletRequest request, HttpServletResponse response);
}
