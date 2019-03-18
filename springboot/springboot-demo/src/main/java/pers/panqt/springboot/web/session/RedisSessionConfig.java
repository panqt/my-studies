package pers.panqt.springboot.web.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 *  @time       2019年03月14日	23:13
 *	@author     panqt
 *
 *	@comment    
 */
@Configuration
// 默认是1800秒过期，这里测试修改为60秒
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
public class RedisSessionConfig {
    
}
