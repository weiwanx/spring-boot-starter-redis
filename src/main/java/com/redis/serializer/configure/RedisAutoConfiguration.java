package com.redis.serializer.configure;

import com.redis.serializer.properties.RedisProperties;
import com.redis.serializer.serializer.RedisSerializerKey;
import com.redis.serializer.serializer.RedisSerializerValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 万喜 <weiwanx@163.com>
 * @description redisTemplate配置
 * @date 2021-01-23
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnProperty(
        value = {
                "spring.redis.host",
                "spring.redis.port"
        }
)
public class RedisAutoConfiguration {

    @Autowired
    RedisProperties redisProperties;

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 设置key序列化方式
        RedisSerializerKey redisSerializerKey = new RedisSerializerKey(redisProperties.getKeyPrefix());
        redisTemplate.setKeySerializer(redisSerializerKey);
        redisTemplate.setHashKeySerializer(redisSerializerKey);

        // 设置value序列化方式
        RedisSerializerValue redisSerializerValue = new RedisSerializerValue();
        redisTemplate.setValueSerializer(redisSerializerValue);
        redisTemplate.setHashValueSerializer(redisSerializerValue);
        return redisTemplate;
    }
}
