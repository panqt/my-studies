package pers.panqt.springcloud.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springcloud.entities.User;
import pers.panqt.springcloud.provider.service.UserService;
import pers.panqt.springcloud.api.*;

import java.util.List;

/**  @author panqt 2019/04/07 4:51
 *
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/get/{userid}")
    @HystrixCommand(fallbackMethod = "hystrixBreaker")
    public User get(@PathVariable("userid") int userid){
        log.debug("provider：[{}]", userid);
        User user = userService.get(userid);
        if(null == user){
            //模拟服务内部出现异常,调用熔断
            throw new RuntimeException("服务出问题了");
        }
        user.setUserName(user.getUserName()+"-provider8001");
        return user;
    }

    /** 这是服务端的熔断 ，
     *  客户端服务降级：{@link UserFallbackFactory}{@link UserClientService}*/
    public User hystrixBreaker(@PathVariable("userid") int userid){
        return new User().setUserName("调用失败了,服务熔断-provider8001");
    }
}
