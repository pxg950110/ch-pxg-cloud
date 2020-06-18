package ch.pxg.cloud.chpxgcloudcommon.util;

import org.omg.CORBA.ObjectHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 2020/6/17  13:53
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/17
 * @Version 1.0.0
 * @description
 * redis 工具类
 * </p>
 */
@Component
public final class RedisUtil {
private final Logger log= LoggerFactory.getLogger(RedisUtil.class);
    // redis
    @Resource
    private RedisTemplate<String ,Object> redisTemplate;

    /*********common***************/
    /**
     * 指定缓存失效时间
     * @param key
     * @param time  秒
     * @return
     */
    public  boolean expire(String key,long time){
        try {
            if (time>0)
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 通过key 获取过期时间
     * @param key
     * @return
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断key 是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 删除一个或者多个key
     * @param key
     */
    public void del(String ... key){
        if (key!=null && key.length>0){
            if (key.length==1)
            {
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

  /*******************string********************/

    /**
     * 普通缓存获取
     * @param key
     * @return
     */
  public Object get(String key){
      return StringUtils.isEmpty(key)?null:redisTemplate.opsForValue().get(key);
  }

    /**
     * redis写入
     * @param key
     * @param value
     * @return
     */
  public boolean set(String key,Object value){
      try {
          redisTemplate.opsForValue().set(key,value);
          return true;
      }catch (Exception e){
          e.printStackTrace();
          log.error(e.getMessage());
          return false;
      }
  }


    /**
     * 写入redis并设置过期时间
     * @param key
     * @param value
     * @param time  (s)
     * @return
     */
  public boolean set(String key,Object value,long time){
      log.info(key);
      log.info(value.toString());
      try {
          redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
          return true;
      }catch (Exception e){
          log.error(e.getMessage());
          e.printStackTrace();
          return false;
      }
  }

    /**
     * 递增序列
     * @param key
     * @param delta
     * @return
     */
  public long incr(String key,long delta){
      if (delta<0){
          throw  new RuntimeException("递增因子必须大于0");
      }
      return redisTemplate.opsForValue().increment(key,delta);
  }


    /**
     * 递减
     * @param key
     * @param delta
     * @return
     */
    public long decr(String key,long delta){
        if (delta<0){
            throw  new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,-delta);
    }
















}
