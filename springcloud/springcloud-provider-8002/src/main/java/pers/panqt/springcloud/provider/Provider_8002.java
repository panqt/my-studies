package pers.panqt.springcloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/** @auther panqt 2019/4/7 7:40
 *
 *  @EnableEurekaClient 开起 eureka client
 */

@MapperScan("pers.panqt.springcloud.provider.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Provider_8002 {

    public static void main(String[] args) {
        SpringApplication.run(Provider_8002.class, args);
    }

}
