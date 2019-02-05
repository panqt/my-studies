package pers.panqt.dubbo.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.panqt.dubbo.provider.api.UserService;
import pers.panqt.dubbo.provider.entry.User;

/**
 *  @time       2019年02月03日	16:04
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
public class DubboController {

    @Reference
    UserService userService;


    @GetMapping("dubbo/{id}")
    public User dubbo(@PathVariable("id") int id){
        User user = userService.findById(id);
        return user;
    }
}
