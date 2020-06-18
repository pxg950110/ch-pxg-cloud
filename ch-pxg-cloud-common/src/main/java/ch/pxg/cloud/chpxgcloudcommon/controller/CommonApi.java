package ch.pxg.cloud.chpxgcloudcommon.controller;

import ch.pxg.cloud.chpxgcloudcommon.mail.MailSendUtil;
import ch.pxg.cloud.chpxgcloudcommon.service.MailService;
import ch.pxg.cloud.chpxgcloudcommon.util.CommonResult;
import ch.pxg.cloud.chpxgcloudcommon.util.EmailCodeVI;
import ch.pxg.cloud.chpxgcloudcommon.util.ResultInfo;
import com.netflix.discovery.EurekaClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 2020/3/9  23:43
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/9
 * @Version 1.0.0
 * @description </p>
 */
@RestController
@Api
public class CommonApi {
    private  final  static Logger log= LoggerFactory.getLogger(CommonApi.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    EurekaClient eurekaClient;
    @Autowired
    MailSendUtil mailSendUtil;
@Autowired
private MailService mailService;

    @ApiOperation("获取服务列表")
    @GetMapping("/serviceurl")
    public List<Map<String , Object>> stringListMap(){
        List<Map<String ,Object>> list=new ArrayList<>();
        List<String> services=discoveryClient.getServices();
        System.out.println(services);
        services.forEach(s -> {
            Map<String , Object> map=new HashMap<>();
            map.put("serverName",s);
            List<ServiceInstance> serviceInstances=discoveryClient.getInstances(s);
//            discoveryClient.getInstances(s);
            map.put("serverInfo",serviceInstances);
            list.add(map);
        });
        return list;
    }


    /**
     * 发送邮箱验证码fa
     */
    @PostMapping("/mail/code")
    @ApiOperation("发送邮箱验证码")
    public  void sendSimpleEmailCode(@RequestBody EmailCodeVI emailCodeVI){
        mailService.sendMail(emailCodeVI);
    }

    @GetMapping("/mail/check/code")
    @ApiOperation("验证邮箱的验证码是否正确")
    public CommonResult<Boolean> checkMailCode(String  msgId, String emailCode, HttpServletRequest request, HttpServletResponse response){
        return mailService.checkMailCode(msgId,emailCode,request,response);
    }
    @GetMapping("/")
    @ApiOperation("测试")
    public String test(String to) {
        mailSendUtil.sendSimpleMail(
                "tezt", "aada", to,
                null
        );
        return "测试";
    }

    @GetMapping("/mail/code/info")
    @ApiOperation("获取邮箱验证码")
    public ResultInfo getMailCode(String msgId){
        return mailService.getMailInfo(msgId);
    }

}
