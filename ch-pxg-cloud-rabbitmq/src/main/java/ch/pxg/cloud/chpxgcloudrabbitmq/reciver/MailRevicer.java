package ch.pxg.cloud.chpxgcloudrabbitmq.reciver;

import ch.pxg.cloud.chpxgcloudrabbitmq.feignclient.CHCloudCommon;
import ch.pxg.cloud.chpxgcloudrabbitmq.producer.EmailCodeVI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 2020/3/17  23:12
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/17
 * @Version 1.0.0
 * @description </p>
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        value = "${rabbit.config.queue.info.routing.mail-key}"
                ), exchange =  @Exchange(value = "${rabbit.config.exchange.name}")
        ,key ="${rabbit.config.queue.info.routing.mail-key}"
        )
)
public class MailRevicer {
    private final Logger log= LoggerFactory.getLogger(MailRevicer.class);
    @Autowired
    private CHCloudCommon chCloudCommon;


    @RabbitHandler
    public void reciveMail(EmailCodeVI emailCodeVI){
       try {
           log.info("发送邮件");
          chCloudCommon.sendSimpleEmailCode(emailCodeVI);
       }catch (Exception e){
           log.info(e.getMessage());
       }
    }
}
