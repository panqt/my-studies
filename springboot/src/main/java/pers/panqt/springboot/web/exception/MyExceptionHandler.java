package pers.panqt.springboot.web.exception;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestControllerAdvice
public class MyExceptionHandler  {

    @ExceptionHandler(ArithmeticException.class)
    public ResultVo ArithmeticException(ArithmeticException e){
        log.error("算术错误："+e.getMessage());
        return new ResultVo(501,"算术错误："+e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class,BindException.class})
    public ResultVo argumentNotValid(Exception e){

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
        log.error(sb.toString());
        return new ResultVo(502,"参数错误："+sb.toString());
    }

    @ExceptionHandler(Exception.class)
    private ResultVo exception(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return new ResultVo(503,e.getMessage());
    }
}

