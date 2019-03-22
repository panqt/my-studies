package pers.panqt.springboot.web.requestparam;

import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.User;

/**
 *  @time       2019年02月01日	14:41
 *	@author     panqt
 *
 *	@comment    参数绑定
 */
@RestController
@RequestMapping("param/binding")
public class ParamBindingController {

    @GetMapping("get-param/{id}")
    public String getParam(@PathVariable("id") String id){

        return id;
    }

    @PostMapping("object")
    public String object(@RequestBody User user){

        return user.toString();
    }

}
