package ch.pxg.cloud.chpxgcloudwechat.server.impl;

import ch.pxg.cloud.chpxgcloudwechat.dao.BillInfoJPA;
import ch.pxg.cloud.chpxgcloudwechat.dao.BillTypeInfoJPA;
import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.model.BillInfoVI;
import ch.pxg.cloud.chpxgcloudwechat.server.WxService;
import ch.pxg.cloud.chpxgcloudwechat.util.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;

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
    private BillInfoJPA billInfoJPA;

    @Autowired
    private BillTypeInfoJPA billTypeInfoJPA;

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
        try {
            //通过集合添加
            Collection<String> collection=new ArrayList<>();
             // userId in(0,openId)
            collection.add("0");
            collection.add(openId);
            return ResultInfo.ok(billTypeInfoJPA.findAllByUserIdIn(collection));
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            //设置返回状态
            response.setStatus(500);
            return ResultInfo.error(e.getMessage());
        }
    }
}



