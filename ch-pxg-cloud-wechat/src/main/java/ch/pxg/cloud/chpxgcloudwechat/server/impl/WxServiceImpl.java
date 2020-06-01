package ch.pxg.cloud.chpxgcloudwechat.server.impl;

import ch.pxg.cloud.chpxgcloudwechat.mapper.BillInfoMapper;
import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.request.BillInfoVI;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.BillRequestModel;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.BillTypeAmount;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.DateEnum;
import ch.pxg.cloud.chpxgcloudwechat.server.WxService;
import ch.pxg.cloud.chpxgcloudwechat.util.ResultInfo;
import com.alibaba.fastjson.JSON;
import com.pxg.clould.chpxgclouldutil.CommonResult;
import com.pxg.clould.chpxgclouldutil.HttpResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.util.calendar.LocalGregorianCalendar;
import sun.util.logging.resources.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/12
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class WxServiceImpl implements WxService {
    private final Logger log = LoggerFactory.getLogger(WxServiceImpl.class);


    @Autowired
    BillInfoMapper billInfoMapper;


    /**
     * 记一笔账单
     * @param billInfo
     * @return
     */
    @Override
    public ResultInfo addBillInfo(BillInfo billInfo, HttpServletRequest request, HttpServletResponse response) {
        log.info(billInfo.toString());
        return null;
    }

    /**
     * 获取所有类别
     * @return
     */
    @Override
    public ResultInfo getBillTypeList(String openId, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }


    /**
     * 获取账单
     * @param billInfoVI
     * @param request
     * @param response
     * @return
     */
    @Override
    public CommonResult getBillInfo(BillInfoVI billInfoVI, HttpServletRequest request, HttpServletResponse response) {
        log.info(billInfoVI.toString());
        // 设置服务端返回状态
        response.setStatus(HttpResultStatus.STATUS500.getStatusCode());
        //  openId不为空
        if (StringUtils.isEmpty(billInfoVI.getUserId())) {
            response.setStatus(HttpResultStatus.STATUS203.getStatusCode());
            //返回openId不为空
            CommonResult.commomResult(null, HttpResultStatus.STATUS203, "userId不允许为空");
        }
        //
        return null;
    }


    @Override
    public void test() {
        BillRequestModel billRequestModel = new BillRequestModel();
        billRequestModel.setBillYear("2020");
        billRequestModel.setBillMonth("2");
        billRequestModel.setBillDay("23");
        billRequestModel.setDateEnum(DateEnum.MONTH);
        try {
            List<BillTypeAmount> billTypeAmounts = billInfoMapper.selectByBillRequestModel(billRequestModel);
            log.info(billTypeAmounts.toString());
            if (billRequestModel.getDateEnum() == DateEnum.DAY || billRequestModel.getDateEnum() == DateEnum.MONTH) {
                for (BillTypeAmount billTypeAmount : billTypeAmounts) {
                    BillInfo billInfo = new BillInfo();
                    billInfo.setBillYear(billRequestModel.getBillYear());
                    billInfo.setBillMonth(billRequestModel.getBillMonth());
                    billInfo.setBillDay(billTypeAmount.getBillDay());
                    billInfo.setUserId("ogYK94ij6CIveNOze2XEMDcatHrM");
                    billInfo.setStatus(0);
                    List<BillInfo> billInfos= billInfoMapper.selectByBillInfo(billInfo);
                    log.info(billInfos.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



