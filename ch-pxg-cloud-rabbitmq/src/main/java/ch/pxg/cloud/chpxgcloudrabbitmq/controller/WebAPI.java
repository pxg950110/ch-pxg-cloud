package ch.pxg.cloud.chpxgcloudrabbitmq.controller;

import ch.pxg.cloud.chpxgcloudrabbitmq.config.RabbitMQConfigModel;
import ch.pxg.cloud.chpxgcloudrabbitmq.feignclient.PythonFeignClinet;
import ch.pxg.cloud.chpxgcloudrabbitmq.producer.EmailCodeVI;
import ch.pxg.cloud.chpxgcloudrabbitmq.producer.LogMessage;
import ch.pxg.cloud.chpxgcloudrabbitmq.sender.Sender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 2020/2/28  1:40
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/2/28
 * @Version 1.0.0
 * @description </p>
 */
@RestController
@Api("rabbit")
public class WebAPI {

    @Autowired
    private Sender sender;
    @Value("${mysql.database.host}")
    String rabbitmqServer;

    @Autowired
    private PythonFeignClinet pythonFeignClinet;
    @Value("${rabbitmq.host}")
    private  String rabbitHost;
    @Value("${rabbitmq.port}")
    private  String rabbitPort;
    @Value("${rabbitmq.username}")
    private  String rabbitUser;
    @Value("${rabbitmq.password}'")
    private  String rabbitPassword;

    @GetMapping("/python/gushi/list")
    @ApiOperation("获取故事列表")
    public Object getGushiList(String url){
        return pythonFeignClinet.getGushiList(url);
    }

    @ApiOperation("获取故事明细")
    @GetMapping("/python/gushi/content")
    public Object getGushiContent(String url){
        return pythonFeignClinet.getGushiContent(url);
    }
    @GetMapping("/")
    @ApiOperation("测试")
    public  String hello(){
        return "hello rabbit";
    }


    @ApiOperation("发送邮箱验证码")
    @PostMapping("/send/mail/code")
    public  void sendMail(@RequestBody EmailCodeVI emailCodeVI){
        sender.sendMailCode(emailCodeVI);
    }


    @ApiOperation("测试接口")
    @GetMapping("/rabbitmq.username")
    public String hi(){
        sender.send(
                new LogMessage(1, UUID.randomUUID().toString(),
                      "测试接口内容执行内容","info","测试信息",new Date(),
                      1
                )
        );

        return rabbitmqServer;
    }

}
