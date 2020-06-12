package ch.pxg.cloud.chpxgcloudauthorserver.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * <p>
 * 2020/6/12  10:12
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/12
 * @Version 1.0.0
 * @description RedisSerializer编码解码类
 * </p>
 */
public class RedisObjectSerializer implements RedisSerializer {
    static final byte[] EMPTY_ARRAY = new byte[0];
    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    /**
     * 编码
     * @param object
     * @return
     * @throws SerializationException
     */
    @Override
    public byte[] serialize(Object object) throws SerializationException {
        // 判断object是否为空
        if (object == null) {
            return EMPTY_ARRAY;
        }
        try {
            return serializer.convert(object);
        } catch (Exception e) {
            return EMPTY_ARRAY;
        }
    }

    /**
     * 解码
     * @param bytes
     * @return
     * @throws SerializationException
     */
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        //
        if (isEmpty(bytes)) {
            return null;
        }
        try {
            return deserializer.convert(bytes);
        } catch (Exception e) {
            throw new SerializationException("Cannot deserialize ", e);
        }
    }

    /**
     * 判断byte[]是否为空
     * @param bytes
     * @return
     */
    private boolean isEmpty(byte[] bytes) {
        return (bytes == null || bytes.length == 0);
    }
}
