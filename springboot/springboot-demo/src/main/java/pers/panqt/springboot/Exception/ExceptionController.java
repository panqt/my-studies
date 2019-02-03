package pers.panqt.springboot.Exception;

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
        return "除0"+1/0;
    }
}
