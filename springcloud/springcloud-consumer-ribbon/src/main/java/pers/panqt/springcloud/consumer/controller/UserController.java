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

    @PostMapping("comsumer/user/add")
    public int add( @RequestBody User user){
        log.debug("provider：[{}]", user);
        int rest = restTemplate.postForObject(REST_URL_PREFIX +"user/add",user, Integer.class);
        return rest;
    }

    @GetMapping("comsumer/user/get/{userid}")
    public User get(@PathVariable("userid") int userid){
        log.debug("comsumer:[{}]", userid);
        User user = restTemplate.getForObject(REST_URL_PREFIX +"user/get/"+userid, User.class);

        return user;
    }

    @GetMapping("comsumer/user/get-list")
    public List<User> getList(@RequestBody User user)throws Exception{
            log.debug("comsumer:[{}]", user);
        List users = restTemplate.getForObject(REST_URL_PREFIX +"user/get-list"+formatParam(user), List.class);
        return users;
    }


    private String formatParam(Object o)throws Exception{
        Class c = o.getClass();
        Field[] fields = c.getDeclaredFields();
        Method[] methods = c.getDeclaredMethods();

        StringBuilder sb = new StringBuilder();
        for(Field field : fields){

            for(Method method : methods){
                if(method.getName().toLowerCase().equals("get"+field.getName().toLowerCase())){
                    Object rest = method.invoke(o);
                    if(rest != null){
                        if(sb.length()!=0){
                            sb.append("&");
                        }
                        sb.append(field.getName()).append("=").append(rest.toString());
                    }
                }
            }
        }
        if(sb.length()!=0){
            sb.insert(0, '?');
        }
        return sb.toString();
    }
}
