package pers.panqt.springboot.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pers.panqt.springboot.web.exception.MyExceptionHandler;

/**
 *  @time       2019年03月18日	9:27
 *	@author     panqt
 *
*	@comment
 */
@Controller
public class ViewController {
    @GetMapping("welcome")
    public String welcome(){
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
}
