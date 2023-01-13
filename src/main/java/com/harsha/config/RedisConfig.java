package com.harsha.config;

import com.harsha.hash.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.function.ObjDoubleConsumer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {


    @Bean
    public JedisConnectionFactory getJedisConnectionFactory(){

        /*RedisStandaloneConfiguration redisCustomConfig = new RedisStandaloneConfiguration();
        redisCustomConfig.setHostName("localhost");
        redisCustomConfig.setPort(6379);
*/
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<Object, Object> getRedisTemplate(){

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getJedisConnectionFactory());
        return redisTemplate;
    }

}
