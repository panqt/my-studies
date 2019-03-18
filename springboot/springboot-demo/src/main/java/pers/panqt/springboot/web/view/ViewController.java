package pers.panqt.springboot.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("fastdfs/home")
    public String fdfshome(){
        return "fastdfs/home";
    }
}
