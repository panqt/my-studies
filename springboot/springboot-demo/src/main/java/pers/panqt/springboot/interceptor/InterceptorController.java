package pers.panqt.springboot.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @time       2019年02月03日	13:48
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
public class InterceptorController {


    @GetMapping("interceptor-test")
    public void interceptor(){
        System.out.println("进入到[ InterceptorController ]");
    }
}
