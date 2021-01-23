package com.redis.serializer.serializer;

import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;

/**
 * @author 万喜 <weiwanx@163.com>
 * @description redis key 序列化规则
 * @date 2021-01-23
 */
public class RedisSerializerKey extends StringRedisSerializer {

    private String keyPrefix;

    private final Charset charset;

    public RedisSerializerKey(String keyPrefix){
        this(keyPrefix, Charset.forName("UTF8"));
    }

    public RedisSerializerKey(String keyPrefix, Charset charset){
        this.keyPrefix = keyPrefix;

        this.charset = charset;
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    @Override
    public String deserialize(byte[] bytes) {
        return super.deserialize(bytes);
    }

    /**
     * 序列化
     *
     * @param string
     * @return
     */
    @Override
    public byte[] serialize(String string) {
        if (StringUtils.isEmpty(keyPrefix)){
            return super.serialize(string);
        }
        String key = String.format("%s:%s", keyPrefix, string);
        return key.getBytes(charset);
    }
}
