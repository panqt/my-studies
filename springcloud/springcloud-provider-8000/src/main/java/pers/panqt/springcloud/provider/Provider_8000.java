package pers.panqt.springcloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/** @auther panqt 2019/4/7 7:40
 *
 *  @EnableEurekaClient 开起 eureka client
 */
@EnableHystrix  //支持 Hystrix dashboard 监控
@EnableCircuitBreaker //熔断器支持 hystrix
@MapperScan("pers.panqt.springcloud.provider.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Provider_8000 {

    public static void main(String[] args) {
        SpringApplication.run(Provider_8000.class, args);
    }

}
