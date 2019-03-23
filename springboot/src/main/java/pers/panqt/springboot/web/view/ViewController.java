package pers.panqt.springboot.web.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.modules.redis.RedisService;
import pers.panqt.springboot.web.exception.MyExceptionHandler;

import javax.servlet.http.Cookie;
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
    @GetMapping("template")
    public String template(){
        return "template";
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
    @GetMapping("login")
    public String login(HttpSession session){
        return "modules/login";
    }

    /**关于 Cookie 属性
     * @see <a>https://www.jianshu.com/p/2fea4478cc76</a> */
    @GetMapping("auth")
    public String auth(HttpSession session,String account,String password){

        //设置session有效期 2 分钟
        session.setMaxInactiveInterval(60*2);
        session.setAttribute("login-info",account+'-'+password);

        log.debug("登陆成功:{}-{}",account,password);

        Cookie cookie = new Cookie("JSESSIONID",session.getId() );
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        cookie.setComment("springboot sessionid");
        cookie.setVersion(0);
        return "redirect:/welcome";
    }
    @GetMapping("logout")
    public String logout(HttpSession session){

        //session 失效
        session.invalidate();
        log.debug("登出成功");
        return "redirect:/welcome";
    }

}
