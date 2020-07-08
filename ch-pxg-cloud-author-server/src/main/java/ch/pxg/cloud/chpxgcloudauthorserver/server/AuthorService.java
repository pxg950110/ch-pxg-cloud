package ch.pxg.cloud.chpxgcloudauthorserver.server;

import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.LoginVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.MailCodeVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.UserRegistVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.MailCodeResponseVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.UserInfoVi;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.UserRegistResponseVI;
import ch.pxg.cloud.chpxgcloudauthorserver.util.CommonResult;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 2020/4/23  11:36
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/23
 * @Version 1.0.0
 * @description </p>
 */
public interface AuthorService {

    /**
     * 会员注册
     * @param registVI
     * @param request
     * @param response
     * @return
     */
    CommonResult<UserRegistResponseVI> regist(UserRegistVI registVI,
                                              HttpServletRequest request, HttpServletResponse response);



    CommonResult<MailCodeResponseVI> sendMailCode(MailCodeVI mailCodeVI, HttpServletRequest request, HttpServletResponse response);

    CommonResult<UserInfoVi> login(LoginVI loginVI, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
