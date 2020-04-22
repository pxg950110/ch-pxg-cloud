package ch.pxg.cloud.chpxgcloudrabbitmq.service.impl;

import ch.pxg.cloud.chpxgcloudrabbitmq.feignclient.CHCloudCommon;
import ch.pxg.cloud.chpxgcloudrabbitmq.service.CHCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 2020/3/10  20:57
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/10
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class CHCommonServiceImpl implements CHCommonService {
    @Autowired
    private CHCloudCommon chCloudCommon;

    @Override
    public void sendMail(String to) {
        chCloudCommon.sendMail(to);
    }
}
