package ch.pxg.cloud.chpxgcloudrabbitmq.sender;

import ch.pxg.cloud.chpxgcloudrabbitmq.producer.EmailCodeVI;
import ch.pxg.cloud.chpxgcloudrabbitmq.producer.LogMessage;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 2020/3/4  0:17
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
public class Sender {
    private  final Logger log= LoggerFactory.getLogger(Sender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;
//    服务后台交换器
    @Value("${rabbit.config.exchange.name}")
    private String EXCHANGE;
//    路由键
    @Value("${rabbit.config.queue.info.routing.key}")
    private String QUEUEINFOROUTINGKEY;

    //mailcheckcode
    @Value("${rabbit.config.queue.info.routing.mail-key}")
    private  String MAILCODE;
    /**
     * 发送消息到rabbitMQ
     * @param logMessage
     */
    public  void send(LogMessage logMessage){
        this.amqpTemplate.convertAndSend(
                this.EXCHANGE,//交换器
                this.QUEUEINFOROUTINGKEY,//路由键
              logMessage
        );

    }

    public void sendMailCode(EmailCodeVI emailCodeVI){
        this.amqpTemplate.convertAndSend(
                this.EXCHANGE,
                this.MAILCODE,
              emailCodeVI
        );
    }
}
