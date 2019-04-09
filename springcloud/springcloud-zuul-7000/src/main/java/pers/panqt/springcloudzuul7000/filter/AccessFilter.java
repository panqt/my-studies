package pers.panqt.springcloudzuul7000.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  @author panqt 2019/04/09 9:54
 *   
 */
@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

    public AccessFilter() {
        super();
    }

    //@Override
    //public boolean isFilterDisabled() {
    //    return false;
    //}

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,PATCH,OPTIONS,HEAD");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Authorization");

        Object token = request.getParameter("accessToken");
        if(token == null){
            log.info("accessToken is null");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("{\"code\":\"999\",\"data\":\"accessToken is null\"}");
            response.setContentType("application/json;charset=UTF-8");
            requestContext.setResponse(response);
        }
        log.info("token:{}",token);
        return null;
    }
}
