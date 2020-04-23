package ch.pxg.cloud.chpxgcloudauthorserver.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/6
 * @Version 1.0.0
 * @description </p>
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String,Object>
        redisTemplate(RedisConnectionFactory factory){
        RedisTemplate template=new RedisTemplate();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer
                =new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setVisibility(
                PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY
        );
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        //
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }


}
