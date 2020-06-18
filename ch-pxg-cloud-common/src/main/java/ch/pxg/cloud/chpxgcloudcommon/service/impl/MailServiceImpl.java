package ch.pxg.cloud.chpxgcloudcommon.service.impl;


import ch.pxg.cloud.chpxgcloudcommon.mail.MailSendUtil;
import ch.pxg.cloud.chpxgcloudcommon.mapper.EmailCodeMapper;
import ch.pxg.cloud.chpxgcloudcommon.model.EmailCode;
import ch.pxg.cloud.chpxgcloudcommon.service.MailService;
import ch.pxg.cloud.chpxgcloudcommon.util.*;
import com.alibaba.fastjson.JSON;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 2020/3/17  17:08
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
    private final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);
    @Autowired
    private MailSendUtil mailSendUtil;

    @Autowired
    RedisUtil redisUtil;
    //过期时间
    @Value("${mail.expire.time}")
    private String expireTime;

    @Autowired
    @Resource
    RedisTemplate redisTemplate;


    @Autowired
    EmailCodeMapper emailCodeMapper;

    /**
     * 发送验证码 并开启事务方式
     * @param emailCodeVI
     */
    @Transactional
    @Override
    public void sendMail(EmailCodeVI emailCodeVI) {
        // 通过  邮箱 查询  数据
        //
        try {
            if (emailCodeVI.getEmailUrl() == null) {
                return;
            }
            List<EmailCode> emailCodes = emailCodeMapper.selectByEmailUrl(emailCodeVI.getEmailUrl());
            log.info(emailCodes.toString());
            if (emailCodes.size() > 0) {
                // 验证key值是否有效
                boolean hasKey = false;
                String code = null;
                EmailCode emailCode = new EmailCode();
                for (EmailCode emailCode1 : emailCodes) {
                    if (redisUtil.hasKey(emailCode1.getMsgId())) {
                        hasKey = true;
                        code = emailCode1.getEmialCode();
                        emailCode = emailCode1;
                        emailCodeMapper.updateStatusbyPrimary(emailCode1.getId());
                    } else {
                        // 更新数据未无效
                        emailCode1.setStatus(2);
                        emailCodeMapper.updateStatusbyPrimary(emailCode1.getId());
                    }
                }
                // 如果key 存在 直接忽略邮箱 新的key写入 redis中 并同步插入到数据库中
                if (hasKey) {
                    redisUtil.set(emailCodeVI.getMsgId(), code, Long.parseLong(expireTime));
                    emailCode.setMsgId(emailCodeVI.getMsgId());
                    // 数据写入数据库
                    emailCodeMapper.insert(emailCode);
                    return;
                }
            }

            log.info("获取后台验证码");
            String subject = "邮箱验证";
            String code = RandmoUtil.getCode(6);
            String content = "欢迎注册皮小怪和皮皮妹的空间:" +
                    "\r\n" +
                    "验证码:" + code;
            // 发送邮件
            Map<String, Object> map = new HashMap<>();
            map.put("subject", subject);
            map.put("code", code);
            map.put("content", content);
            map.put("to", emailCodeVI.getEmailUrl());
            // 生成  邮箱验证码  0-9
            EmailCode emailCode2 = new EmailCode();
            // msgId为空返回错误
            emailCode2.setMsgId(emailCodeVI.getMsgId());
            emailCode2.setMsgDetail(JSON.toJSONString(map));
            emailCode2.setEmialCode(code);
            // to email
            emailCode2.setEmailUrl(emailCodeVI.getEmailUrl());
            //
            emailCode2.setCreateTime(new Date());
            //
            emailCode2.setStatus(0);
            log.info(emailCode2.toString());
            emailCodeMapper.insert(emailCode2);
            redisUtil.set(emailCode2.getMsgId(), emailCode2.getEmialCode(), Long.parseLong(expireTime));
            mailSendUtil.sendSimpleMail(subject, content, emailCodeVI.getEmailUrl(), null);
            log.info("==========end发送邮箱===========");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }

    @Override
    public ResultInfo getMailInfo(String msgId) {
        try {
            EmailCode emailCode = null;
            if (emailCode.getEmialCode() == null) {
                return ResultInfo.wain("错误消息ID未发送邮件");
            }
            // 过期时间
            log.info(expireTime);
            if (new Date().getTime() - emailCode.getCreateTime().getTime() > Long.parseLong(expireTime)) {
                return ResultInfo.wain("验证码已过时间限制，请重新获取");
            }
            return ResultInfo.ok(emailCode.getEmialCode());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.error(e.getMessage());
        }
    }

    /**
     * 验证邮箱的code是否正确
     * @param msgId
     * @param emailCode
     * @param request
     * @param response
     * @return
     */
    @Override
    public CommonResult<Boolean> checkMailCode(String msgId, String emailCode, HttpServletRequest request, HttpServletResponse response) {
        //redis判断key 是否存在
        //
        boolean hasKey = redisUtil.hasKey(msgId);
        if (!hasKey) {
            return CommonResult.commomResult(false, HttpResultStatus.STATUS300, "邮箱验证错误，确认是否发送邮箱  &&  验证码是否过期");
        } else {
            if (emailCode.equals(redisUtil.get("key").toString())) {
                return CommonResult.commomResult(true, HttpResultStatus.STATUS200);
            } else {
                return CommonResult.commomResult(false, HttpResultStatus.STATUS300, "邮箱验证错错误");
            }
        }

    }
}
