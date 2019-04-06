package pers.panqt.springboot.modules.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 *  @time       2019年02月02日	10:19
 *	@author     panqt
 *
 *	@comment    
 */
@EnableCaching
@Configuration
public class RedisConfig  extends CachingConfigurerSupport {

    /**  key生成策略
     */
    //@Override
    //@Bean
    //public KeyGenerator keyGenerator() {
    //    return new KeyGenerator() {
    //        @Override
    //        public Object generate(Object target, Method method, Object... params) {
    //            StringBuilder sb = new StringBuilder();
    //            sb.append(target.getClass().getName());
    //            sb.append(method.getName());
    //            for (Object obj : params) {
    //                sb.append(obj.toString());
    //            }
    //            return sb.toString();
    //        }
    //    };
    //}

    /**  缓存管理器
     */
    //@Bean
    //public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
    //    RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory).build();
    //    return redisCacheManager;
    //}

    @Autowired
    ObjectMapper objectMapper;


    /**防止redis入库序列化乱码的问题
     * */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        //key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        //value序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
