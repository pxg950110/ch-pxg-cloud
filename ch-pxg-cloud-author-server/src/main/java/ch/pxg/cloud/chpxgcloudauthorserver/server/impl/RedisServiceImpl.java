package ch.pxg.cloud.chpxgcloudauthorserver.server.impl;

import ch.pxg.cloud.chpxgcloudauthorserver.server.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 2020/4/15  17:03
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/15
 * @Version 1.0.0
 * @description   redis操作实现类</p>
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 保存属性
     * @param key
     * @param value
     * @param time
     */
    @Override
    public void set(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key,value,time);
    }

    /**
     * 保存属性
     * @param key
     * @param value
     */
    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 获取属性
     * @param key
     */
    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除属性
     * @param key
     */
    @Override
    public Boolean del(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 批量删除属性
     * @param keys
     */
    @Override
    public Long del(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * 设置过期时间
     * @param key
     * @param time
     */
    @Override
    public Boolean expire(String key, long time) {
        return null;
    }

    /**
     * 获取过期时间
     * @param key
     */
    @Override
    public Long getExpire(String key) {
        return null;
    }

    /**
     * 判断是否有该属性
     * @param key
     */
    @Override
    public Boolean hasKey(String key) {
        return null;
    }

    /**
     * 按delta递增
     * @param key
     * @param delta
     */
    @Override
    public Long incr(String key, long delta) {
        return null;
    }

    /**
     * 按delta递减
     * @param key
     * @param delta
     */
    @Override
    public Long decr(String key, long delta) {
        return null;
    }

    /**
     * 获取Hash结构中的属性
     * @param key
     * @param hashKey
     */
    @Override
    public Object hGet(String key, String hashKey) {
        return null;
    }

    /**
     * 向Hash结构中放入一个属性
     * @param key
     * @param hashKey
     * @param value
     * @param time
     */
    @Override
    public Boolean hSet(String key, String hashKey, Object value, long time) {
        return null;
    }

    /**
     * 向Hash结构中放入一个属性
     * @param key
     * @param hashKey
     * @param value
     */
    @Override
    public void hSet(String key, String hashKey, Object value) {

    }

    /**
     * 直接获取整个Hash结构
     * @param key
     */
    @Override
    public Map<Object, Object> hGetAll(String key) {
        return null;
    }

    /**
     * 直接设置整个Hash结构
     * @param key
     * @param map
     * @param time
     */
    @Override
    public Boolean hSetAll(String key, Map<String, Object> map, long time) {
        return null;
    }

    /**
     * 直接设置整个Hash结构
     * @param key
     * @param map
     */
    @Override
    public void hSetAll(String key, Map<String, Object> map) {

    }

    /**
     * 删除Hash结构中的属性
     * @param key
     * @param hashKey
     */
    @Override
    public void hDel(String key, Object... hashKey) {

    }

    /**
     * 判断Hash结构中是否有该属性
     * @param key
     * @param hashKey
     */
    @Override
    public Boolean hHasKey(String key, String hashKey) {
        return null;
    }

    /**
     * Hash结构中属性递增
     * @param key
     * @param hashKey
     * @param delta
     */
    @Override
    public Long hIncr(String key, String hashKey, Long delta) {
        return null;
    }

    /**
     * Hash结构中属性递减
     * @param key
     * @param hashKey
     * @param delta
     */
    @Override
    public Long hDecr(String key, String hashKey, Long delta) {
        return null;
    }

    /**
     * 获取Set结构
     * @param key
     */
    @Override
    public Set<Object> sMembers(String key) {
        return null;
    }

    /**
     * 向Set结构中添加属性
     * @param key
     * @param values
     */
    @Override
    public Long sAdd(String key, Object... values) {
        return null;
    }

    /**
     * 向Set结构中添加属性
     * @param key
     * @param time
     * @param values
     */
    @Override
    public Long sAdd(String key, long time, Object... values) {
        return null;
    }

    /**
     * 是否为Set中的属性
     * @param key
     * @param value
     */
    @Override
    public Boolean sIsMember(String key, Object value) {
        return null;
    }

    /**
     * 获取Set结构的长度
     * @param key
     */
    @Override
    public Long sSize(String key) {
        return null;
    }

    /**
     * 删除Set结构中的属性
     * @param key
     * @param values
     */
    @Override
    public Long sRemove(String key, Object... values) {
        return null;
    }

    /**
     * 获取List结构中的属性
     * @param key
     * @param start
     * @param end
     */
    @Override
    public List<Object> lRange(String key, long start, long end) {
        return null;
    }

    /**
     * 获取List结构的长度
     * @param key
     */
    @Override
    public Long lSize(String key) {
        return null;
    }

    /**
     * 根据索引获取List中的属性
     * @param key
     * @param index
     */
    @Override
    public Object lIndex(String key, long index) {
        return null;
    }

    /**
     * 向List结构中添加属性
     * @param key
     * @param value
     */
    @Override
    public Long lPush(String key, Object value) {
        return null;
    }

    /**
     * 向List结构中添加属性
     * @param key
     * @param value
     * @param time
     */
    @Override
    public Long lPush(String key, Object value, long time) {
        return null;
    }

    /**
     * 向List结构中批量添加属性
     * @param key
     * @param values
     */
    @Override
    public Long lPushAll(String key, Object... values) {
        return null;
    }

    /**
     * 向List结构中批量添加属性
     * @param key
     * @param time
     * @param values
     */
    @Override
    public Long lPushAll(String key, Long time, Object... values) {
        return null;
    }

    /**
     * 从List结构中移除属性
     * @param key
     * @param count
     * @param value
     */
    @Override
    public Long lRemove(String key, long count, Object value) {
        return null;
    }
}
