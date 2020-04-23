package ch.pxg.cloud.chpxgcloudauthorserver.server.impl;

import ch.pxg.cloud.chpxgcloudauthorserver.feignclient.RabbitFeignClinet;
import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;
import ch.pxg.cloud.chpxgcloudauthorserver.server.UserService;
import ch.pxg.cloud.chpxgcloudauthorserver.util.EmailCodeVI;
import ch.pxg.cloud.chpxgcloudauthorserver.util.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 2020/3/17  14:47
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/17
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class UserServoceImpl implements UserService {

    private final Logger log= LoggerFactory.getLogger(UserServoceImpl.class);
    @Autowired
    private RabbitFeignClinet rabbitFeignClinet;
    /**
     * 用户登录
     * @param userInfo
     * @return
     */
    @Override
    public ResultInfo login(UserInfo userInfo) {
        log.info(userInfo.toString());
//        默认用户名和密码
        return ResultInfo.ok(userInfo);
    }

    /**
     * 通过邮箱获取验证码
     * @param emailUrl
     * @return
     */
    @Override
    public ResultInfo emailCode(String emailUrl) {
        EmailCodeVI emailCodeVI=new EmailCodeVI(emailUrl);
        // 发送数据到rabbit
        rabbitFeignClinet.sendSimpleEmailCode(emailCodeVI);
        log.info(emailCodeVI.toString());
        return ResultInfo.ok(emailCodeVI.getMsgId());
    }
}
