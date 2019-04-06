package pers.panqt.springcloud.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springcloud.entities.User;
import pers.panqt.springcloud.provider.service.UserService;

import java.util.List;

/**  @author panqt 2019/04/07 4:51
 *   
 */
@Slf4j
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("user/add")
    public int add( @RequestBody User user){
        log.debug("provider：[{}]", user);
        return userService.add(user);
    }

    @GetMapping("user/get")
    public User get(@RequestParam int userid){
        log.debug("provider：[{}]", userid);
        return userService.get(userid);
    }


    @GetMapping("user/get-list")
    public List<User> getList( User user){
        log.debug("provider：[{}]", user);
        return userService.list(user);
    }
}
