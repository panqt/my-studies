package pers.panqt.springboot.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pers.panqt.springboot.web.exception.SessionNoExistException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**  @author panqt 2019/04/04 21:56
 *   控制一下页面跳转
 */
@Slf4j
@Component
public class SessionInterceptor2 extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.preHandle(request, response, handler);

        log.debug("SessionInterceptor2");

        HttpSession session = request.getSession();
        String sessionId = session.getId();

        Object o = session.getAttribute("login-info");
        if (o == null) {
            log.debug("Session为空，登陆检查失败，请登录!");
            response.sendRedirect(request.getContextPath()+"/modules/login");
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
