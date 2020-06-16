package ch.pxg.cloud.chpxgcloudcommon.service.impl;

import ch.pxg.cloud.chpxgcloudcommon.dao.EmailCodeJpa;
import ch.pxg.cloud.chpxgcloudcommon.mail.MailSendUtil;
import ch.pxg.cloud.chpxgcloudcommon.model.EmailCode;
import ch.pxg.cloud.chpxgcloudcommon.service.MailService;
import ch.pxg.cloud.chpxgcloudcommon.util.EmailCodeVI;
import ch.pxg.cloud.chpxgcloudcommon.util.RandmoUtil;
import ch.pxg.cloud.chpxgcloudcommon.util.ResultInfo;
import com.alibaba.fastjson.JSON;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 2020/3/17  17:08
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
public class MailServiceImpl implements MailService {
    //日志
    private  final Logger log= LoggerFactory.getLogger(MailServiceImpl.class);
    @Autowired
    private MailSendUtil mailSendUtil;

    //过期时间
    @Value("${mail.expire.time}")
    private String expireTime;


    @Autowired
    private EmailCodeJpa emailCodeJpa;


    /**
     * 发送验证码 并开启事务方式
     * @param emailCodeVI
     */
    @Transactional
    @Override
    public void sendMail(EmailCodeVI emailCodeVI) {
        try {
            if (emailCodeVI.getEmailUrl()==null){
                return;
            }
            log.info("获取后台验证码");
            String subject="邮箱验证";
            String code= RandmoUtil.getCode(6);
            String content="欢迎注册皮小怪和皮皮妹的空间:" +
                    "\r\n" +
                    "验证码:"+code;
            // 发送邮件

            Map<String,Object> map=new HashMap<>();
            map.put("subject",subject);
            map.put("code",code);
            map.put("content",content);
            map.put("to",emailCodeVI.getEmailUrl());
            // 生成  邮箱验证码  0-9
            EmailCode emailCode = new EmailCode();
            // msgId为空返回错误
            emailCode.setMsgId(emailCodeVI.getMsgId());
            emailCode.setMsgDetail(JSON.toJSONString(map));
            emailCode.setEmialCode(code);
            // to email
            emailCode.setEmailUrl(emailCodeVI.getEmailUrl());
            //
            emailCode.setCreateTime(new Date());
            //
            emailCode.setStatus(0);
            emailCodeJpa.save(emailCode);
            mailSendUtil.sendSimpleMail(subject,content,emailCodeVI.getEmailUrl(),null);
            log.info("==========end发送邮箱===========");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }

    @Override
    public ResultInfo getMailInfo(String msgId) {
        try {
            EmailCode emailCode=emailCodeJpa.findAllByMsgId(msgId);
            if (emailCode.getEmialCode()==null){
                return ResultInfo.wain("错误消息ID未发送邮件");
            }
            // 过期时间
            log.info(expireTime);
            if (new Date().getTime()-emailCode.getCreateTime().getTime()>Long.parseLong(expireTime)){
                return ResultInfo.wain("验证码已过时间限制，请重新获取");
            }
            return ResultInfo.ok(emailCode.getEmialCode());
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error(e.getMessage());
        }
    }
}
