package ch.pxg.cloud.chpxgcloudrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitBootstrapConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 2020/3/3  23:09
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/3
 * @Version 1.0.0
 * @description </p>
 * mq的配置类
 */
@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.host}")
    private  String rabbitHost;
    @Value("${rabbitmq.port}")
    private  String rabbitPort;
    @Value("${rabbitmq.username}")
    private  String rabbitUser;
    @Value("${rabbitmq.password}'")
    private  String rabbitPassword;

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
     * 直连交换机
     * @return
     */
    public DirectExchange directExchange(){
        return new DirectExchange(this.EXCHANGE);
    }

    /**
     * 日志队列
     * @return
     */
    @Bean
    public Queue applog(){
        return new Queue(this.QUEUEINFOROUTINGKEY,true);
    }


    @Bean
    public Queue MAILCODE(){
        return new Queue(this.MAILCODE ,true);
    }

    /**
     *
     * @return
     */
    @Bean
   public Binding bindingMail(){
       return BindingBuilder.bind(MAILCODE())
       .to(directExchange())
       .with(this.MAILCODE);
   }


    /**
     * 日志队列和交换机绑定
     */
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(applog())
                .to(directExchange())
                .with(this.QUEUEINFOROUTINGKEY);
    }


}
