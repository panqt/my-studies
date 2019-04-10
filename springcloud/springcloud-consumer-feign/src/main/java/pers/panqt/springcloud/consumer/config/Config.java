package pers.panqt.springcloud.consumer.config;

import com.netflix.loadbalancer.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pers.panqt.springcloud.api.UserFallbackFactory;

/**  @author panqt 2019/04/07 5:06
 *   
 */
@Slf4j
@Configuration
public class Config {

    @Bean
    public IRule iRule(){
        //ribbon 负载均衡算法
        //feign 封装了ribbon,童谣使用ribbon的负载均衡算法
        return new WeightedResponseTimeRule();
    }


    //注入 FallbackFactory 服务降级，包名不在在application下。扫描不到
    @Bean
    public UserFallbackFactory userFallbackFactory(){
        return new UserFallbackFactory();
    }
}
