package pers.panqt.springcloudmessagebus.service;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *  @time       2019年02月02日	14:53
 *	@author     panqt
 *
 *	@comment    rabbitmq 监听器
 */
@Service
public class RabbitmqService {

    private RabbitTemplate rabbitTemplate;

    private AmqpAdmin amqpAdmin;

    @Autowired
    public RabbitmqService(RabbitTemplate rabbitTemplate, AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
        this.rabbitTemplate = rabbitTemplate;

        /** direct ： 单对单的 */
        this.amqpAdmin.declareExchange(new DirectExchange("cloud.bus.exchange.direct"));
        this.amqpAdmin.declareQueue(new Queue("cloud.bus.queue",true));
        this.amqpAdmin.declareBinding(new Binding("cloud.bus.queue", Binding.DestinationType.QUEUE , "cloud.bus.exchange.direct", "cloud.bus.queue", null));
    }

    /**  监听rcustom.queue.direct队列
     */
    @RabbitListener(queues = "cloud.bus.queue")
    public void receive(String mqMessage){
        System.out.println("点对点:"+mqMessage);
    }

    /** 点对点发送 direct */
    public void sendToDirect(String mqMessage ){
        rabbitTemplate.convertAndSend("cloud.bus.exchange.direct","cloud.bus.queue",mqMessage);
    }
}
