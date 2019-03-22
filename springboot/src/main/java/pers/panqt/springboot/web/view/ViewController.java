package pers.panqt.springboot.web.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.modules.redis.RedisService;
import pers.panqt.springboot.web.exception.MyExceptionHandler;

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
    @GetMapping("auth")
    public String auth(HttpSession session,String account,String password){
        redisService.setValue("login-info-"+session.getId(),account+'-'+password);
        log.debug("[ViewController.login line 59]: {}","登陆成功:"+account+'-'+password);
        return "redirect:/welcome";
    }
    @GetMapping("logout")
    public String logout(HttpSession session){
        redisService.remove("login-info-"+session.getId());
        log.debug("[ViewController.logout line 70]: {}","登出成功");
        return "redirect:/welcome";
    }
}
