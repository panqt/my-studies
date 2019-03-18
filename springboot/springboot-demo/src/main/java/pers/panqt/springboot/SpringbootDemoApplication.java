package pers.panqt.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //开启定时调度
@EnableAsync //开启异步
@MapperScan("pers.panqt.springboot.mybatis") //扫描mybatis mapper接口
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        /**
         * Springboot整合Elasticsearch 在项目启动前设置一下的属性，防止报错
         * 解决 netty 冲突后初始化client时还会抛出异常
         * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
         * 和 redis session 冲突
         */
        System.setProperty("es.set.netty.runtime.available.processors", "false");

        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}

