package ch.pxg.cloud.chpxgcloudauthorserver.server.impl;

import ch.pxg.cloud.chpxgcloudauthorserver.feignclient.RabbitFeignClinet;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.MailCodeVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.UserRegistVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.MailCodeResponseVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.UserRegistResponseVI;
import ch.pxg.cloud.chpxgcloudauthorserver.server.AuthorService;
import ch.pxg.cloud.chpxgcloudauthorserver.util.CommonResult;
import ch.pxg.cloud.chpxgcloudauthorserver.util.CommonUtil;
import ch.pxg.cloud.chpxgcloudauthorserver.util.EmailCodeVI;
import ch.pxg.cloud.chpxgcloudauthorserver.util.HttpResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.Regexp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * <p>
 * 2020/4/23  14:36
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/23
 * @Version 1.0.0
 * @description </p>
 * 会员服务中心
 */
@Service
public class AuthorServiceImpl implements AuthorService  , Serializable {

    private static final long serialVersionUID = 2664724877017936511L;
    // v1.0版本aop 日志暂时不加入 1.0.0版本日志未采用mq
    //日志处理
    private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    @Autowired
    RabbitFeignClinet rabbitFeignClinet;
    /**
     * 会员注册
     * @param registVI
     * @param request
     * @param response
     * @return
     */
    @Override
    public CommonResult<UserRegistResponseVI> regist(UserRegistVI registVI, HttpServletRequest request, HttpServletResponse response) {
        log.info(registVI.getMessageId());
        // mybatis  改为jpa的操作
        return null;
    }

    // 发送邮件
    @Override
    public CommonResult<MailCodeResponseVI> sendMailCode(MailCodeVI mailCodeVI, HttpServletRequest request, HttpServletResponse response) {
        // 邮箱验证写入rabbitmq
        // 验证邮箱
        if (!CommonUtil.checkEmailURL(mailCodeVI.getEmailUrl())){
            response.setStatus(HttpResultStatus.STATUS400.getStatusCode());
            return CommonResult.commomResult(null,HttpResultStatus.STATUS400,"邮箱不正确");
        }
        EmailCodeVI emailCodeVI=new EmailCodeVI(mailCodeVI.getEmailUrl());
        // 发送数据到rabbit
        rabbitFeignClinet.sendSimpleEmailCode(emailCodeVI);
        return CommonResult.commomResult(new MailCodeResponseVI(emailCodeVI.getMsgId()),HttpResultStatus.STATUS200);
    }

}
