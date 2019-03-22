package pers.panqt.springboot.web.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @Pointcut("execution(* pers.panqt.springboot..*Controller.*(..)) " +
            "|| execution(* pers.panqt.springboot..*ExceptionHandler.*(..))")
    public void logpoint(){}


    @Before("logpoint()")
    public void logRequestParams(JoinPoint joinPoint) throws Exception{
        if(!logger.isDebugEnabled()){
            return;
        }
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuilder stringBuilder = new StringBuilder();
        Object[] args = joinPoint.getArgs();
        List<String> ls = new LinkedList<>();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        stringBuilder.append(String.format("请求映射:[ %s ]", httpServletRequest.getRequestURI()));
        stringBuilder.append(String.format(",sessionid:[ %s ]", httpServletRequest.getRequestedSessionId())).append(",参数:[");
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
        logger.debug(stringBuilder.toString());
    }


    @AfterReturning(pointcut ="logpoint()",returning = "ret")
    public void logResponseParams(JoinPoint joinPoint, Object ret) throws Exception{
        try {
            if(!logger.isDebugEnabled()) {
                return;
            }
            logger.debug("响应参数:[{}]", ret == null?"":this.objectMapper.writeValueAsString(ret));
        }catch (Throwable e){
            logger.error("记录请求参数异常",e);
        }
    }
}
