package pers.panqt.springboot.web.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.modules.login.CaptchaService;
import pers.panqt.springboot.modules.redis.RedisService;
import pers.panqt.springboot.web.exception.MyExceptionHandler;
import pers.panqt.springboot.web.interceptor.SessionInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  @time       2019年03月18日	9:27
 *	@author     panqt
 *
*	@comment
 */
@Slf4j
@Controller
public class ViewController {

    @Autowired
    private RedisService redisService;

    @GetMapping("welcome")
    public String welcome(){
        log.debug("welcome 首页");
        return "welcome";
    }
    @GetMapping("modules/template")
    public String template(){
        return "modules/template";
    }
    @GetMapping("modules/fastdfs")
    public String fdfshome(){
        return "modules/fastdfs";
    }
    @GetMapping("modules/mail")
    public String mail(){
        return "modules/mail";
    }
    @GetMapping("modules/redis")
    public String redis(){
        return "modules/redis";
    }
    @GetMapping("modules/elasticsearch")
    public String elasticsearch(){
        return "modules/elasticsearch";
    }
    @GetMapping("modules/rabbitmq")
    public String rabbitmq(){
        return "modules/rabbitmq";
    }
    @GetMapping("modules/ajax")
    public String ajax(){
        return "modules/ajax";
    }


    @Autowired
    CaptchaService captchaService;

    @GetMapping("modules/login")
    public String login(HttpServletRequest request) throws Exception {
        request.setAttribute("captcha", captchaService.createCaptcha(request));
        return "modules/login";
    }
}
