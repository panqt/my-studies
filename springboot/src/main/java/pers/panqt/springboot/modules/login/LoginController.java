package pers.panqt.springboot.modules.login;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.session.MapSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.modules.redis.RedisService;
import pers.panqt.springboot.web.interceptor.SessionInterceptor;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Properties;

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
    @Autowired
    private CaptchaService captchaService;

    /**关于 Cookie 属性
     * @see <a>https://www.jianshu.com/p/2fea4478cc76</a>
     *
     * @see SessionInterceptor#preHandle
     * */
    @GetMapping("auth")
    public ResultVo auth(HttpServletRequest request, HttpSession session, String account, String password,String captcha){

        if(!captchaService.checkCaptcha(request, captcha)){
            return new ResultVo(500,"验证码错误");
        }

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

    @GetMapping("captcha")
    public ResultVo captcha(HttpServletRequest request) throws Exception{
        return new ResultVo(captchaService.createCaptcha(request));
    }
}
