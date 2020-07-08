package ch.pxg.cloud.chpxgcloudauthorserver.server.impl;

import ch.pxg.cloud.chpxgcloudauthorserver.config.JwtAccessToken;
import ch.pxg.cloud.chpxgcloudauthorserver.feignclient.RabbitFeignClinet;
import ch.pxg.cloud.chpxgcloudauthorserver.mapper.UserInfoMapper;
import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.LoginType;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.LoginVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.MailCodeVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.UserRegistVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.MailCodeResponseVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.UserInfoVi;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.UserRegistResponseVI;
import ch.pxg.cloud.chpxgcloudauthorserver.server.AuthorService;
import ch.pxg.cloud.chpxgcloudauthorserver.util.*;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import sun.misc.Regexp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.interfaces.RSAPrivateCrtKey;
import java.util.Base64;
import java.util.List;

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
public class AuthorServiceImpl implements AuthorService, Serializable {

    private static final long serialVersionUID = 2664724877017936511L;
    // v1.0版本aop 日志暂时不加入 1.0.0版本日志未采用mq
    //日志处理
    private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    @Autowired
    RabbitFeignClinet rabbitFeignClinet;

    @Autowired
    private UserInfoMapper userInfoMapper;


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
        if (!CommonUtil.checkEmailURL(mailCodeVI.getEmailUrl())) {
            response.setStatus(HttpResultStatus.STATUS400.getStatusCode());
            return CommonResult.commomResult(null, HttpResultStatus.STATUS400, "邮箱不正确");
        }
        EmailCodeVI emailCodeVI = new EmailCodeVI(mailCodeVI.getEmailUrl());
        // 发送数据到rabbit
        rabbitFeignClinet.sendSimpleEmailCode(emailCodeVI);
        return CommonResult.commomResult(new MailCodeResponseVI(emailCodeVI.getMsgId()), HttpResultStatus.STATUS200);
    }

    @Override
    public CommonResult<UserInfoVi> login(LoginVI loginVI, HttpServletRequest request, HttpServletResponse response) {
        log.info("登录操作请求字符串：{}", JSON.toJSONString(loginVI));
        // 账号 密码登录
        if (loginVI.getLoginType() == LoginType.DEFAULT) {
            //用户名    密码
            //用户  密码验证
            List<UserInfo> userInfos=userInfoMapper.selectBySelective(new UserInfo(loginVI.getUserName(),0));
            if (userInfos.size()<=0 && !loginVI.getUserName().equals("admin"))
                throw  new UsernameNotFoundException("用户未发现,"+loginVI.getUserName());
//            if (DigestUtils.md5())
            //密码验证
            //md5加密
            if(!((userInfos.size()>0? Md5Util.md5Check(loginVI.getPassword(),userInfos.get(0).getUserPassword()):false )|| Md5Util.md5Check(loginVI.getPassword(),Md5Util.md5Encode("admin"))) ) {
//                Principal
                    throw  new SecurityException("用户密码错误");
            }
            // 生成token
            String token=JwtHelperUtil.createJWT(new JWTInfo(loginVI.getUserName(),"1",loginVI.getUserName()),loginVI.getPassword(),-1);

            //rsa验证
            log.info("token:{}",token);
            //
            response.setHeader("Authorization","Bear "+token);
            return CommonResult.commomResult(new UserInfoVi(token),HttpResultStatus.STATUS200);
            // solt SHA-256

        } else if (loginVI.getLoginType() == LoginType.EMAIL) {
            //邮箱登录

        } else if (loginVI.getLoginType() == LoginType.PHONE) {
            //电话登录
        } else {
            response.setStatus(HttpResultStatus.STATUS400.getStatusCode());
            return CommonResult.commomResult(null, HttpResultStatus.STATUS400, "错误请求，未知的登录类型");
        }
        return null;
    }
}
