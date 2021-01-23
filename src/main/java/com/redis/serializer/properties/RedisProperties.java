package com.redis.serializer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 万喜 <weiwanx@163.com>
 * @description 描述内容
 * @date 2021-01-23
 */
@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    /**
     * key前缀（微服务架构，每个服务设置不同前缀，易于区分）
     */
    private String keyPrefix;
}
