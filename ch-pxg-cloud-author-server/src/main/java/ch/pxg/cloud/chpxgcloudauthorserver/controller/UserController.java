package ch.pxg.cloud.chpxgcloudauthorserver.controller;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.UserRegistVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.UserVI;
import ch.pxg.cloud.chpxgcloudauthorserver.server.UserService;
import ch.pxg.cloud.chpxgcloudauthorserver.util.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by SuperS on 2017/9/25.
 *
 * @author SuperS
 */
@RestController
@Api(description = "token测试")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ApiOperation("测试")
    public Principal user(Principal user){
        return user;
    }


    /**
     * 用户登录
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("/user/login")
    public ResultInfo login(@RequestBody UserInfo userInfo){
        return userService.login(userInfo);
    }


    @ApiOperation("用户注册")
    @PostMapping("/user/regist")
    public ResultInfo regist(@RequestBody UserVI userVI){
        return userService.regist(userVI);
    }

    @ApiOperation("获取邮箱验证码")
    @GetMapping("/user/email/code")
    public ResultInfo emailCode(String emailUrl){
        return userService.emailCode(emailUrl);
    }
}
