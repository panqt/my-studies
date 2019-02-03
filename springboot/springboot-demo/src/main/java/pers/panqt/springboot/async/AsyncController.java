package pers.panqt.springboot.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @time       2019年02月02日	21:45
 *	@author     panqt
 *
 *	@comment    启动类pers.panqt.springboot.SpringbootDemoApplication
 *              加注解 @EnableAsync	才能开启异步
 */
@RestController
public class AsyncController {

    @GetMapping("async")
    public String async(){
        hello();
        return "success";
    }

    @Async
    public void hello() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中...");
    }
}
