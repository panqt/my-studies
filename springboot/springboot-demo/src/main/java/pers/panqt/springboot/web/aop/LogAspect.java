package pers.panqt.springboot.web.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.List;

/**
 *  @time       2019年02月03日	14:31
 *	@author     panqt
 *
 *	@comment    
 */
@Aspect
@Component
public class LogAspect {

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Resource
    private ObjectMapper objectMapper;

    @Pointcut("execution(* pers.panqt.springboot..*Controller.*(..))")
    public void logpoint(){}


    @Before("logpoint()")
    public void logParams(JoinPoint joinPoint) throws Exception{

        if(!logger.isDebugEnabled())return;

        StringBuilder stringBuilder = new StringBuilder();
        Object[] args = joinPoint.getArgs();
        List<String> ls = new LinkedList<>();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        stringBuilder.append(String.format("请求[%s]", signature.toShortString())).append(",参数:[");

        Parameter[] params = signature.getMethod().getParameters();
        int idx = 0;
        for (Object arg : args) {
            Parameter param = params[idx++];
            if(param.isAnnotationPresent(RequestBody.class)) {
                ls.add(this.objectMapper.writeValueAsString(arg));
            }else /*if(param.isAnnotationPresent(RequestParam.class))*/{
                ls.add(String.valueOf(arg));
            }
        }
        stringBuilder.append(String.join(",",ls)).append("]");
        this.logger.debug(stringBuilder.toString());
    }
}
