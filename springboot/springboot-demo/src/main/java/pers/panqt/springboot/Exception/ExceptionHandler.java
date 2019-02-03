package pers.panqt.springboot.Exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  @time       2019年02月03日	13:09
 *	@author     panqt
 *
 *	@comment    
 */
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String handler(Exception e){
        if(e instanceof ArithmeticException){
            return "算术错误"+e.getMessage();
        }
        return "内部错误";
    }
}
