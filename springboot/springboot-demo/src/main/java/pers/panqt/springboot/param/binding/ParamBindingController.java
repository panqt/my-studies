package pers.panqt.springboot.param.binding;

import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.Person;

/**
 *  @time       2019年02月01日	14:41
 *	@author     panqt
 *
 *	@comment    参数绑定
 */
@RestController
public class ParamBindingController {

    @GetMapping("hello/{id}")
    public String hello(@PathVariable("id") String id){

        return id;
    }

    @PostMapping("person")
    public String person(@RequestBody Person person){

        return person.toString();
    }
}
