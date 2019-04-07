package pers.panqt.springcloud.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/** @see pers.panqt.springcloud.provider.config.Config
 *  provider：  @EnableHystrix  //支持 Hystrix dashboard 监控
 *              @EnableCircuitBreaker //熔断器支持 hystrix
 *
 *  maven: spring-boot-starter-actuator
 */

@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard.class, args);
    }

}
