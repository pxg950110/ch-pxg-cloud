package ch.pxg.cloud.chpxgcloudauthorserver.controller;

import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.LoginVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.UserRegistVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.UserInfoVi;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.UserRegistResponseVI;
import com.pxg.clould.chpxgclouldutil.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 2020/4/23  10:35
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/23
 * @Version 1.0.0
 * @description </p>
 */
@RestController
@RequestMapping("auth")
@Api("用户权限相关操作接口")
public class AuthorController {

    /**
     *
     * @param loginVI
     * @param request
     * @param response
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("login")
    public CommonResult<UserInfoVi> login(LoginVI loginVI, HttpServletRequest request, HttpServletResponse response){
        return  CommonResult.success(new UserInfoVi());
    }


    /**
     * 用户注册接口
     * @param userRegistVI
     * @param request
     * @param response
     * @return
     */
    @ApiOperation("会员注册")
    @PostMapping("/regist")
    public CommonResult<UserRegistResponseVI> regist(UserRegistVI userRegistVI, HttpServletRequest request, HttpServletResponse response){
        return null;
    }
}
