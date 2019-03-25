package pers.panqt.springboot.web.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import pers.panqt.springboot.web.view.ViewController;

import javax.servlet.http.HttpSession;
import pers.panqt.springboot.web.interceptor.SessionInterceptor;

/**
 *  @time       2019年03月14日	23:13
 *	@author     panqt
 *
 *	@comment    开启 Spring管理 Session，使用redis缓存
 *              默认是60x30秒过期，这里测试修改为60秒
 * SpringSession详解：  <a>https://www.cnblogs.com/lxyit/p/9672097.html</a>
 * 登陆认证:    {@link ViewController#auth}
 * 登出：      {@link ViewController#logout}
 * 登陆检查：   {@link SessionInterceptor}
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
public class RedisSessionConfig {
    
}
