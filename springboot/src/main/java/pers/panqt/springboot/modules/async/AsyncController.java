package pers.panqt.springboot.modules.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.panqt.springboot.SpringbootDemoApplication;

/**
 *  @time       2019年02月02日	21:45
 *	@author     panqt
 *
 *	@see SpringbootDemoApplication
 *       启动类加注解 @EnableAsync	才能开启异步调用
 *       特别注意：异步方法和调用方法一定要分开 写在不同的类中,如果写在一个类中,是没有效果的
 *       异步方法 和 调用方法 要 写在两个类里
 */
@RestController
public class AsyncController {

    @Autowired AsyncService asyncService;

    @GetMapping("async")
    public String async(){
        asyncService.async();
        return "success";
    }
}
