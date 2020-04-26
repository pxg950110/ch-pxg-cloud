package ch.pxg.cloud.chpxgcloudauthorserver.server;

import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.UserRegistVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.UserRegistResponseVI;
import com.pxg.clould.chpxgclouldutil.CommonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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






}
