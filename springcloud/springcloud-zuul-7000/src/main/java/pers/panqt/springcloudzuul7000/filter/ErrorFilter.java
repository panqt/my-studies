package pers.panqt.springcloudzuul7000.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**  @author panqt 2019/04/09 19:24
 *   
 */
@Slf4j
@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1000;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("ErrorFilter");
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        if(throwable != null){
            throwable.printStackTrace();

            HttpServletResponse response = ctx.getResponse();
            HttpServletRequest request = ctx.getRequest();

            ctx.setSendZuulResponse(false);
            response.setContentType("application/json;charset=UTF-8");
            try {
                response.getOutputStream().print("{\"code\":\"500\",\"data\":\"unkown error\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.setStatus(200);
            ctx.setResponse(response);
        }

        return null;
    }
}
