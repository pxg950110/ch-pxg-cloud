package ch.pxg.cloud.chpxgcloudswaggerui.service.impl;

import ch.pxg.cloud.chpxgcloudswaggerui.feignclient.RabbitServerFeignClient;
import ch.pxg.cloud.chpxgcloudswaggerui.feignclient.SidecarAPIFeignClient;
import ch.pxg.cloud.chpxgcloudswaggerui.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 2020/2/29  20:08
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/2/29
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private  RabbitServerFeignClient rabbitServerFeignClient;
    @Autowired
    private SidecarAPIFeignClient sidecarAPIFeignClient;
    @Override
    public String test() {
        return "aaaaaa"+rabbitServerFeignClient.getTest();
    }

    @Override
    public Object test2(String url) {
        return sidecarAPIFeignClient.getUser(url);
    }
}
