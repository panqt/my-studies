package pers.panqt.springcloud.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pers.panqt.springcloud.api.UserClientService;
import pers.panqt.springcloud.entities.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**  @author panqt 2019/04/07 5:13
 *   
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserClientService userClientService;


    @GetMapping("comsumer/user/get/{userid}")
    public User add( @PathVariable("userid") int userid){
        log.debug("provider：[{}]", userid);
        User user = userClientService.get(userid);
        return user.setUserName(user.getUserName()+" feign");
    }
}
