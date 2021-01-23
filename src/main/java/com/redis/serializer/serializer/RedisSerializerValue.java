package com.redis.serializer.serializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author 万喜 <weiwanx@163.com>
 * @description redis value序列化规则
 * @date 2021-01-23
 */
@Slf4j
public class RedisSerializerValue extends GenericJackson2JsonRedisSerializer {

    @Override
    public <T> T deserialize(byte[] source, Class<T> type) throws SerializationException {
        try {
            return super.deserialize(source, type);
        }catch (SerializationException e){
            log.info("not deserialize of data : {}", source);
        }
        return null;
    }
}
