package pers.panqt.springboot.modules.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.MapSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.modules.redis.RedisService;
import pers.panqt.springboot.web.interceptor.SessionInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *  @time       2019年03月18日	9:27
 *	@author     panqt
 *
*	@comment
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private RedisService redisService;

    /**关于 Cookie 属性
     * @see <a>https://www.jianshu.com/p/2fea4478cc76</a>
     *
     * @see SessionInterceptor#preHandle
     * */
    @PostMapping("auth")
    public ResultVo auth(HttpSession session, String account, String password){

        //设置session有效期 30 分钟
        session.setMaxInactiveInterval(MapSession.DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS);
        session.setAttribute("login-info",account+'-'+password);

        log.debug("登陆成功:{}-{}",account,password);

        Cookie cookie = new Cookie("JSESSIONID",session.getId() );
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        cookie.setComment("springboot sessionid");
        cookie.setVersion(0);
        return new ResultVo("登陆成功");
    }

    @GetMapping("logout")
    public ResultVo logout(HttpSession session){
        //session 失效
        session.invalidate();
        log.debug("登出成功");
        return new ResultVo("登出成功");
    }

}
