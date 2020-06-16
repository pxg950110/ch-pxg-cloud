package ch.pxg.cloud.chpxgcloudrabbitmq.reciver;

import ch.pxg.cloud.chpxgcloudrabbitmq.feignclient.CHCloudCommon;
import ch.pxg.cloud.chpxgcloudrabbitmq.producer.LogMessage;
import ch.pxg.cloud.chpxgcloudrabbitmq.service.CHCommonService;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 2020/3/4  11:20
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/4
 * @Version 1.0.0
 * @description </p>
 */
@Component
@RabbitListener(
  bindings = @QueueBinding(
          value = @Queue(
                  value = "${rabbit.config.queue.info.routing.key}"
          ),
          exchange = @Exchange(value = "${rabbit.config.exchange.name}"),
          key = "${rabbit.config.queue.info.routing.key}"

  )
)
public class Revicer {

    @Autowired
    private CHCommonService chCommonService;

    @Autowired
    private  CHCloudCommon chCloudCommon;



    @RabbitHandler
    private  void reciver(LogMessage logMessage){
        try {
            chCloudCommon.sendMail("pxg950110@163.com");
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(
                JSON.toJSONString(logMessage)
        );
    }
    //  接收发送邮箱的指令

    //
}
