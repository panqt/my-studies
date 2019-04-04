package pers.panqt.springboot.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.session.MapSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pers.panqt.springboot.web.config.WebMvcConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.panqt.springboot.web.exception.SessionNoExistException;
import pers.panqt.springboot.modules.login.LoginController;
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
     * @see LoginController#auth
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("SessionInterceptor");
        /**禁用缓存的方式 <a>https://www.cnblogs.com/firstdream/p/8309584.html</a>
         * response.setDateHeader("Expires", System.currentTimeMillis()+1*60*60*1000);
         * */
        if(log.isDebugEnabled()){
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Pragma","no-cache");
            response.setDateHeader("Expires",0);
        }

        HttpSession session = request.getSession();
        String sessionId = session.getId();

        Object o = session.getAttribute("login-info");
        if (o == null) {
            log.debug("Session为空，登陆检查失败，请登录!");
            throw new SessionNoExistException();
        }
        //刷新session有效期
        session.setMaxInactiveInterval(MapSession.DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS);
        log.debug("登陆检查通过 SessionId:[{}]",sessionId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
