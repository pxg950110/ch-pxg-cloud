package ch.pxg.cloud.chpxgcloudrabbitmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitBootstrapConfiguration;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

    private static Logger log= LoggerFactory.getLogger(RabbitMQConfig.class);
    @Value("${rabbitmq.host}")
    private  String rabbitHost;
    @Value("${rabbitmq.port}")
    private  String rabbitPort;
    @Value("${rabbitmq.username}")
    private  String rabbitUser;
    @Value("${rabbitmq.password}")
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


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory=new CachingConnectionFactory();
        log.info("rabbitmq  username:{}",rabbitUser);
        log.info("rabbitmq  password:{}",rabbitPassword);
        cachingConnectionFactory.setUsername(rabbitUser);
        cachingConnectionFactory.setPassword(rabbitPassword);
        cachingConnectionFactory.setAddresses(rabbitHost+":"+rabbitPort);
//        cachingConnectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CHANNEL);
        return cachingConnectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate( ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
@Bean
    public SimpleRabbitListenerContainerFactory factory(
                                                        ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory=new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }




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
