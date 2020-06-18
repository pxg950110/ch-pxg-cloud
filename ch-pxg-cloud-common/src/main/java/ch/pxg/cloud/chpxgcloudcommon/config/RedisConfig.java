package ch.pxg.cloud.chpxgcloudcommon.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

import java.security.KeyPair;

/**
 * <p>
 * 2020/6/16  17:44
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/16
 * @Version 1.0.0
 * @description </p>
 */
@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private String redisPort;
    @Value("${redis.password}")
    private String redisPassword;

    @Value("${redis.databaseindex}")
    private  String redisDataBase;
    private static final int MAX_IDLE = 200; //最大空闲连接数
    private static final int MAX_TOTAL = 1024; //最大连接数
    private static final long MAX_WAIT_MILLIS = 10000; //建立连接最长等待时间


    public RedisConnectionFactory redisConnectionFactory(String host,int port ,String password,int maxIdle,int maxTotal,long maxWaitMillis,int index){
        JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
        //  host
        jedisConnectionFactory.setHostName(host);
        //  port
        jedisConnectionFactory.setPort(port);
       if (!StringUtils.isEmpty(password)) {jedisConnectionFactory.setPassword(password);}
       // 数据库
        if (index!=0)
            jedisConnectionFactory.setDatabase(index);
        jedisConnectionFactory.setPoolConfig(poolConfig(
                maxIdle,maxTotal,maxWaitMillis,false
        ));
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
   public JedisPoolConfig poolConfig(int maxIdle,int maxTotal, long maxWaitMillis,boolean testOnborrow){
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(maxTotal);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setTestOnBorrow(testOnborrow);
        return config;
   }


    @Bean

    @SuppressWarnings("all")

    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(
                redisConnectionFactory(
                        redisHost,Integer.valueOf(redisPort),null,MAX_IDLE,MAX_TOTAL,MAX_WAIT_MILLIS,Integer.valueOf(redisDataBase)
                )
        );


        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();

        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(om);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key采用String的序列化方式

        template.setKeySerializer(stringRedisSerializer);

        // hash的key也采用String的序列化方式

        template.setHashKeySerializer(stringRedisSerializer);

        // value序列化方式采用jackson

        template.setValueSerializer(jackson2JsonRedisSerializer);

        // hash的value序列化方式采用jackson

        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.afterPropertiesSet();

        return template;

    }
}
