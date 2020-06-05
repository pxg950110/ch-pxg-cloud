package ch.pxg.cloud.chpxgcloudwechat.server.impl;

import ch.pxg.cloud.chpxgcloudwechat.mapper.BillInfoMapper;
import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.request.BillInfoVI;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.*;
import ch.pxg.cloud.chpxgcloudwechat.server.WxService;
import ch.pxg.cloud.chpxgcloudwechat.util.ResultInfo;
import ch.pxg.cloud.chpxgcloudwechat.util.CommonResult;
import ch.pxg.cloud.chpxgcloudwechat.util.HttpResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
    public CommonResult<BillModel> getBillModelInfo(BillInfoVI billInfoVI, HttpServletRequest request, HttpServletResponse response) {
        // 验证查询是否含有openId
        if (StringUtils.isEmpty(billInfoVI.getUserId())){
            return CommonResult.commomResult(null,HttpResultStatus.STATUS405,"openId必须要有");
        }
        log.info(billInfoVI.toString());
        // 设置 requestModel
        BillRequestModel requestModel = new BillRequestModel(billInfoVI.getBillYear()
                , billInfoVI.getBillMonth(), billInfoVI.getBillDay(), billInfoVI.getDateEnum(), billInfoVI.getUserId());
        boolean hasBillInfo = billInfoVI.isHasBillInfo();
        //日期
        // 某一天的数据必须都获取
        if (billInfoVI.getDateEnum() == DateEnum.DAY) {
            // 获取每天的数据
            BillRequestModel dayModel = requestModel;
            List<BillTypeAmount> dayBillTypeAmount = billInfoMapper.selectByBillRequestModel(dayModel);
            //
            DayBillModel dayBillModel = getDayBillModel(dayModel,hasBillInfo,billInfoVI.getStartNumber(),billInfoVI.getPageSize());
            return CommonResult.commomResult(dayBillModel, HttpResultStatus.STATUS200);
        } else if (billInfoVI.getDateEnum() == DateEnum.MONTH) {
            // 一个月的数据
            BillRequestModel monthRequestModel = requestModel;
            List<BillTypeAmount> monthBillTypeAmount = billInfoMapper.selectByBillRequestModel(monthRequestModel);
            MonthBillModel monthBillModel = new MonthBillModel();
            monthBillModel.setAmountList(monthBillTypeAmount);
            log.info(monthBillTypeAmount.toString());
            // 查询 一个月下的所有记账单
            List<String> dayList = billInfoMapper.selectchildDateByBillRequestModel(monthRequestModel);
            log.info(dayList.toString());
            List<BillModel> dayBillModels = new ArrayList<>();
            for (String day : dayList) {
                DayBillModel dayBillModel = getDayBillModel(new BillRequestModel(
                        monthRequestModel.getBillYear(), monthRequestModel.getBillMonth(), day,
                        DateEnum.DAY, monthRequestModel.getUserId()
                ),hasBillInfo,billInfoVI.getStartNumber(),billInfoVI.getPageSize());
                dayBillModels.add(dayBillModel);
            }
            monthBillModel.setChirdernList(dayBillModels);
            return CommonResult.commomResult(monthBillModel, HttpResultStatus.STATUS200);
        } else if (billInfoVI.getDateEnum() == DateEnum.YEAR) {
            // 年报 暂时不处理
            return null;
        } else {
            return CommonResult.commomResult(null, HttpResultStatus.STATUS304);
        }
    }
    public DayBillModel getDayBillModel(BillRequestModel dayModel, boolean hasBillInfo,long startNumer,long pageSize) {
        DayBillModel dayBillModel = new DayBillModel();
        dayBillModel.setAmountList(billInfoMapper.selectByBillRequestModel(dayModel));
        // 获取日报下的所有数据
        BillInfo billInfo = new BillInfo(dayModel.getBillYear(),dayModel.getBillMonth(),dayModel.getBillDay()
        ,0,dayModel.getUserId());
        if (hasBillInfo) {
            dayBillModel.setBillInfoList(billInfoMapper.selectByBillInfo(billInfo));
        }
        return dayBillModel;
    }


    /**
     * 获取最大的年月
     * @return
     */
    @Override
    public CommonResult<String> getMaxBillDateInfo(String userId ,HttpServletRequest request, HttpServletResponse response) {
        return CommonResult.commomResult(billInfoMapper.getMaxBillDateInfo(userId),HttpResultStatus.STATUS200);
    }
}



