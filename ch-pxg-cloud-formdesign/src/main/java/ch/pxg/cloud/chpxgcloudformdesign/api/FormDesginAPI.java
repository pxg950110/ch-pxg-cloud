package ch.pxg.cloud.chpxgcloudformdesign.api;

import ch.pxg.cloud.chpxgcloudformdesign.utils.CommonResult;
import ch.pxg.cloud.chpxgcloudformdesign.utils.HttpResultStatus;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 2020/7/8  17:34
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/7/8
 * @Version 1.0.0
 * @description </p>
 */
@RestController
@RequestMapping("/api")
public class FormDesginAPI {
    @GetMapping("/test")
    @ApiOperation(value = "测试")
    public CommonResult<String> test(){
        return CommonResult.commomResult("hello formDesign", HttpResultStatus.STATUS200);
    }
}
