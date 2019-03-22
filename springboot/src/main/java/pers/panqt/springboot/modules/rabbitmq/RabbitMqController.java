package pers.panqt.springboot.modules.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.RabbitMqMessage;
import pers.panqt.springboot.entry.ResultVo;


/**  @auther panqt 2019/02/02 15:49
 */
@RestController
@RequestMapping("rabbitmq")
public class RabbitMqController {

    @Autowired
    RabbitmqService rabbitmqService;

    /** 测试方法:
     *          启动一台发送主机，注释掉监听器
     *          再启动一台接收主机，注意改http端口。
     * */

    @PostMapping("direct")
    public ResultVo direct(@RequestBody RabbitMqMessage rabbitMqMessage){
        rabbitmqService.sendToDirect(rabbitMqMessage);
        return new ResultVo();
    }

    @PostMapping("topic")
    public ResultVo topic(@RequestBody RabbitMqMessage rabbitMqMessage){
        rabbitmqService.sendTotopic(rabbitMqMessage);
        return new ResultVo();
    }
}
