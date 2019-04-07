package pers.panqt.springcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/** @auther panqt 2019/4/7 7:16
 *
 *  @EnableEurekaServer 开起 eureka server
 */

@SpringBootApplication
@EnableEurekaServer
public class Eureka_9002 {

    public static void main(String[] args) {
        SpringApplication.run(Eureka_9002.class, args);
    }

}
