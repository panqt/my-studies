package pers.panqt.springboot.web.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @time       2019年02月03日	13:24
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
public class ExceptionController {

    @GetMapping("by-zero")
    public String byZero(){
        System.out.println("by-zero");
        return "除0"+1/0;
    }
}
