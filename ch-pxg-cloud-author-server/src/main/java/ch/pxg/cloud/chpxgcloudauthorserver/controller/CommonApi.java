package ch.pxg.cloud.chpxgcloudauthorserver.controller;

import ch.pxg.cloud.chpxgcloudauthorserver.util.CommonResult;
import ch.pxg.cloud.chpxgcloudauthorserver.util.HttpResultStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 2020/7/1  13:58
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/7/1
 * @Version 1.0.0
 * @description </p>
 */
@RestController
@Api("测试")
public class CommonApi {
    @ApiOperation("测试")
    @GetMapping("/api/test")
    public CommonResult<String> testInfo(HttpServletRequest request, HttpServletResponse response){
        String  Authorization= request.getHeader("Authorization");
        System.out.println(Authorization);
        return CommonResult.commomResult("返回结果成功", HttpResultStatus.STATUS200);
    }
}
