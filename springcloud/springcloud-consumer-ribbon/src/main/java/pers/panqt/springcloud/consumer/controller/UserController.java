package pers.panqt.springcloud.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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

    //private static final String REST_URL_PREFIX = "http://127.0.0.1:8000/";
    private static final String REST_URL_PREFIX = "http://springcloud-provider/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("comsumer/user/get/{userid}")
    public User get(@PathVariable("userid") int userid){
        log.debug("comsumer:[{}]", userid);
        User user = restTemplate.getForObject(REST_URL_PREFIX +"user/get/{1}", User.class, userid);
        user.setUserName(user.getUserName()+" ribbon");
        return user;
    }
}
