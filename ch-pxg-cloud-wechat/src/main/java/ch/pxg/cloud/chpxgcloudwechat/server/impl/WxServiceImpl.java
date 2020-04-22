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

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * 2020/3/12  17:47
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
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
    public ResultInfo addBillInfo(BillInfo billInfo) {
        log.info(billInfo.toString());
        return null;
    }

    /**
     * 获取所有类别
     * @return
     */
    @Override
    public ResultInfo getBillTypeList(String openId) {
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
            return ResultInfo.error(e.getMessage());
        }
    }
}



