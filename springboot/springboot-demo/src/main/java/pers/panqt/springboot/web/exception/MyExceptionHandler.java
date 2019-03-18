package pers.panqt.springboot.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 *  @time       2019年02月03日	13:09
 *	@author     panqt
 *
 *	@comment    
 */
@RestControllerAdvice
public class MyExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public String handler(Exception e){

        if(e instanceof ArithmeticException){
            logger.error("算术错误："+e.getMessage());
            return "算术错误："+e.getMessage();
        }else if (e instanceof MethodArgumentNotValidException){
            StringBuilder sb = new StringBuilder();
            List<ObjectError> errors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            for (ObjectError oe : errors){
                String s = oe.getCodes()[0];
                String[] parts = s.split("\\.");  //用分割的方法得到字段名
                String part1 = parts[ parts.length-1];
                sb.append("[").append(part1).append(":").append(oe.getDefaultMessage()).append("];");
            }
            logger.error(sb.toString());
            return "参数错误："+sb.toString();
        }
        e.printStackTrace();
        return "内部错误";
    }
}

