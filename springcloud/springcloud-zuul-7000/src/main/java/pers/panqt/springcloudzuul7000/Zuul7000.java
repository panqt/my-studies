package pers.panqt.springcloudzuul7000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class Zuul7000 {

    public static void main(String[] args) {
        SpringApplication.run(Zuul7000.class, args);
    }

}
