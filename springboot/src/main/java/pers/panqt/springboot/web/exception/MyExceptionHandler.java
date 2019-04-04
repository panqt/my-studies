package pers.panqt.springboot.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.web.enums.StatusCodeEnum;

import javax.servlet.http.HttpServletResponse;
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
    public ResultVo arithmeticException(ArithmeticException e){
        log.error("算术错误："+e.getMessage());
        return new ResultVo(StatusCodeEnum.ARITHMETIC_ERROR.getCode(),StatusCodeEnum.ARITHMETIC_ERROR.getDesc());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo argumentNotValid(MethodArgumentNotValidException e){
        //return new ResultVo(StatusCodeEnum.PARAM_CHECK_ERROR.getCode(),StatusCodeEnum.PARAM_CHECK_ERROR.getDesc());
        return new ResultVo(StatusCodeEnum.PARAM_CHECK_ERROR.getCode(),e.getMessage());
    }
    @ExceptionHandler(BindException.class)
    public ResultVo bindException(BindException e){
        //return new ResultVo(StatusCodeEnum.PARAM_CHECK_ERROR.getCode(),StatusCodeEnum.PARAM_CHECK_ERROR.getDesc());
        return new ResultVo(StatusCodeEnum.PARAM_CHECK_ERROR.getCode(),e.getMessage());
    }

    private String dealWithArgError(List<ObjectError> errors){
        StringBuilder sb = new StringBuilder();
        for (ObjectError oe : errors){
            String s = oe.getCodes()[0];
            String[] parts = s.split("\\.");
            String part1 = parts[ parts.length-1];
            sb.append("[").append(part1).append(":").append(oe.getDefaultMessage()).append("];");
        }
        log.error(sb.toString());
        return sb.toString();
    }

    @ExceptionHandler(SessionNoExistException.class)
    private ResultVo exception(SessionNoExistException e){
        log.error("session为空");
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        response.setStatus(200);
        return new ResultVo(StatusCodeEnum.SESSION_NOT_EXIST.getCode(),StatusCodeEnum.SESSION_NOT_EXIST.getDesc());
    }

    @ExceptionHandler(Exception.class)
    private ResultVo exception(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return new ResultVo(StatusCodeEnum.UNKOWN_ERROR.getCode(),StatusCodeEnum.UNKOWN_ERROR.getDesc());
    }
}

