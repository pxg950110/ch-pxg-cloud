package ch.pxg.cloud.chpxgcloudauthorserver.controller;

import ch.pxg.cloud.chpxgcloudauthorserver.server.RedisService;
import com.pxg.clould.chpxgclouldutil.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 2020/4/15  17:15
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/15
 * @Version 1.0.0
 * @description </p>
 */
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private RedisService redisService;
    @GetMapping("test")
    @ApiOperation("测试")
    public CommonResult<String> test(String key, String massage){
        redisService.set(key, massage,60000);
        return CommonResult.success(massage);
    }
}
