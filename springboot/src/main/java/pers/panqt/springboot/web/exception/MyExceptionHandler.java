package pers.panqt.springboot.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.panqt.springboot.entry.ResultVo;

import java.util.List;

/**
 *  @time       2019年02月03日	13:09
 *	@author     panqt
 *
 *	@comment
 */
@RestControllerAdvice
public class MyExceptionHandler  {

    private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResultVo handler(Exception e){

        if(e instanceof ArithmeticException){
            logger.error("算术错误："+e.getMessage());
            return new ResultVo(500,"算术错误："+e.getMessage());
        }else if (e instanceof MethodArgumentNotValidException || e instanceof  BindException){
            List<ObjectError> errors = null;
            if(e instanceof MethodArgumentNotValidException){
                errors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            }else {
                errors = ((BindException) e).getAllErrors();
            }

            StringBuilder sb = new StringBuilder();
            for (ObjectError oe : errors){
                String s = oe.getCodes()[0];
                String[] parts = s.split("\\.");
                String part1 = parts[ parts.length-1];
                sb.append("[").append(part1).append(":").append(oe.getDefaultMessage()).append("];");
            }
            logger.error(sb.toString());
            return new ResultVo(500,"参数错误："+sb.toString());
        }
        e.printStackTrace();
        return new ResultVo(500,e.getMessage());
}
}

