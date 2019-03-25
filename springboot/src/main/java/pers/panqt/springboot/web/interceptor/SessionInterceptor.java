package pers.panqt.springboot.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pers.panqt.springboot.web.config.WebMvcConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pers.panqt.springboot.web.view.ViewController;

/**  @author panqt 2019/03/22 16:46
 *   登陆检查
 */
@Slf4j
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

    /**
     * 拦截器线程不安全，不要在方法外定义变量
     *
     * @see WebMvcConfig#addInterceptors
     *
     * @see ViewController#auth
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String sessionId = session.getId();

        if(request.getSession().isNew()){
            log.debug("session 是新创建,[{}]",request.getSession().getId());
        }

        Object o = session.getAttribute("login-info");
        if (o == null) {
            log.debug("登陆检查失败，请登录!");
            response.sendRedirect(request.getContextPath()+"/welcome");
            return false;
        }
        //刷新session有效期
        session.setMaxInactiveInterval(60*2);
        log.debug("登陆检查通过 SessionId:[{}]",sessionId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 禁用缓存的方式 <a>https://www.cnblogs.com/firstdream/p/8309584.html</a>
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(log.isDebugEnabled()){
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Pragma","no-cache");
            response.setDateHeader("Expires",0);
        }

        //response.setDateHeader("Expires", System.currentTimeMillis()+1*60*60*1000);
    }
}
