package pers.panqt.springboot.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.panqt.springboot.entry.User;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

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
    public RabbitmqService(RabbitTemplate rabbitTemplate,AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
        this.rabbitTemplate = rabbitTemplate;

        amqpAdmin.declareExchange(new DirectExchange("rabbit.exchange.direct"));
        amqpAdmin.declareQueue(new Queue("rabbit.queue",true));
        amqpAdmin.declareBinding(new Binding("rabbit.queue", Binding.DestinationType.QUEUE , "rabbit.exchange.direct", "rabbit.queue", null));


        amqpAdmin.declareExchange(new TopicExchange("rabbit.exchange.topic"));
        amqpAdmin.declareQueue(new Queue("huaihua",true));
        amqpAdmin.declareQueue(new Queue("changsha",true));
        amqpAdmin.declareQueue(new Queue("news",true));
        amqpAdmin.declareQueue(new Queue("wather",true));
        amqpAdmin.declareBinding(new Binding("huaihua", Binding.DestinationType.QUEUE , "rabbit.exchange.topic", "huaihua.*", null));
        amqpAdmin.declareBinding(new Binding("changsha", Binding.DestinationType.QUEUE , "rabbit.exchange.topic", "changsha.*", null));
        amqpAdmin.declareBinding(new Binding("news", Binding.DestinationType.QUEUE , "rabbit.exchange.topic", "*.news", null));
        amqpAdmin.declareBinding(new Binding("wather", Binding.DestinationType.QUEUE , "rabbit.exchange.topic", "*.wather", null));

    }

    //监听rabbit.queue队列
    @RabbitListener(queues = "rabbit.queue")
    public void receive(User user){
        System.out.println("rabbit.queue:"+user);
    }



    @RabbitListener(queues = "huaihua")
    public void receive1(User user){
        System.out.println("huaihua:"+user.toString());
    }

    @RabbitListener(queues = "changsha")
    public void receive2(User user){
        System.out.println("changsha:"+user);
    }
    @RabbitListener(queues = "news")
    public void receive3(User user){
        System.out.println("news:"+user);
    }

    @RabbitListener(queues = "wather")
    public void receive4(User user){
        System.out.println("wather:"+user);
    }

    public void send(String message,String local,String type){
        User user = new User();//可以直接传送对象，但要序列化
        user.setUserName(message);
        rabbitTemplate.convertAndSend("rabbit.exchange.topic",local+"."+type,user);
    }
}
