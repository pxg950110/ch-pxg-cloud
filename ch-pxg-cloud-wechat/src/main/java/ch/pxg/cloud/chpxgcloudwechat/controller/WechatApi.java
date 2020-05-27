package ch.pxg.cloud.chpxgcloudwechat.controller;

import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.model.OpenIdModel;
import ch.pxg.cloud.chpxgcloudwechat.server.WxService;
import ch.pxg.cloud.chpxgcloudwechat.util.AppletUtil;
import ch.pxg.cloud.chpxgcloudwechat.util.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/2/28
 * @Version 1.0.0
 * @description </p>
 */
@RestController
@Api(description = "微信相关接口")
public class WechatApi {

    private final Logger logger = LoggerFactory.getLogger(WechatApi.class);


    @Autowired
    private WxService wxService;

    @GetMapping("/test")
    @ApiOperation("测试")
    public Object test(HttpServletResponse response, HttpServletRequest request) {
        System.out.println(request);
        return "test";
    }

    //账单相关的api接口
//
    /**
     * 账单类型
     */
    @GetMapping("/billinfo/type/list")
    @ApiOperation("获取账单类型")
    public ResultInfo getBillTypeInfo(String openId, HttpServletRequest request, HttpServletResponse response) {
        return wxService.getBillTypeList(openId,request,response);
    }
//
//    @PostMapping("/billinfo/type/add")
//    @ApiOperation("添加账单类型")
//    public ResultInfo addBillTypeInfo(@RequestBody BillTypeInfo billTypeInfo) {
//        return wxService.addBillTypeInfo(billTypeInfo);
//    }
//
    @PostMapping("/billinfo/add")
    @ApiOperation("添加账单")
    public ResultInfo addBillInfo(@RequestBody BillInfo billInfo, HttpServletRequest request, HttpServletResponse response) {
        return wxService.addBillInfo(billInfo,request,response);
    }
//
//
//    @PostMapping("/billinfo/get")
//    @ApiOperation("获取账单")
//    public ResultInfo getBillInfo(@RequestBody BillInfoVI billInfoVI) {
//        return wxService.getBillInfo(billInfoVI);
//    }

    @GetMapping("/openid")
    @ApiOperation("获取openid")
    public ResultInfo getOpenIdByCode(String code, HttpServletRequest request, HttpServletResponse response) {
        OpenIdModel openIdModel = AppletUtil.getOpenIdByCode(code);
        if (openIdModel.getOpenId() == null || openIdModel.getOpenId().equals(""))
            return ResultInfo.error("获取openid失败");
        return ResultInfo.ok(openIdModel);
    }

}
