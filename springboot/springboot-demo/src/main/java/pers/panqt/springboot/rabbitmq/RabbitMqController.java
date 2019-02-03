package pers.panqt.springboot.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.panqt.springboot.rabbitmq.RabbitmqService;

/**
 *  @time       2019年02月02日	15:49
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
public class RabbitMqController {

    @Autowired
    RabbitmqService rabbitmqService;

    @GetMapping("rabbitmq")
    public String rabbitmq(String message,String local,String type){
        rabbitmqService.send(message,local,type);
        return "";
    }
}
