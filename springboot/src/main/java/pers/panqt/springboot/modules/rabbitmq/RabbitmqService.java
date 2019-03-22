package pers.panqt.springboot.modules.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.panqt.springboot.entry.RabbitMqMessage;
import pers.panqt.springboot.entry.User;

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

        /** direct ： 单对单的 */
        amqpAdmin.declareExchange(new DirectExchange("springboot.direct"));
        amqpAdmin.declareQueue(new Queue("点对点",true));
        amqpAdmin.declareBinding(new Binding("点对点", Binding.DestinationType.QUEUE , "springboot.direct", "direct.queue", null));

        /** topic : 话题模式.    路由(Exchange) 按路由键(RoutingKey)匹配,把接收到的消息，分发到多个队列
         *                      比如接受到消息的 RoutingKey 是 huaihua.news
         *                      这个 RoutingKey 匹配 怀化(huaihua.*) 和 新闻(*.news) 两个队列，就会把消息发送给两个队列
         *
         *                      * 可以代替一个任意标识符 ；# 可以代替零个或多个标识符
         * */
        amqpAdmin.declareExchange(new TopicExchange("springboot.topic"));
        amqpAdmin.declareQueue(new Queue("huaihua",true));
        amqpAdmin.declareQueue(new Queue("changsha",true));
        amqpAdmin.declareQueue(new Queue("news",true));
        amqpAdmin.declareQueue(new Queue("wather",true));
        amqpAdmin.declareBinding(new Binding("huaihua", Binding.DestinationType.QUEUE , "springboot.topic", "huaihua.*", null));
        amqpAdmin.declareBinding(new Binding("changsha", Binding.DestinationType.QUEUE , "springboot.topic", "changsha.*", null));
        amqpAdmin.declareBinding(new Binding("news", Binding.DestinationType.QUEUE , "springboot.topic", "*.news", null));
        amqpAdmin.declareBinding(new Binding("wather", Binding.DestinationType.QUEUE , "springboot.topic", "*.wather", null));

    }

    /**  监听rabbit.queue队列
     */
    @RabbitListener(queues = "点对点")
    public void receive(RabbitMqMessage mqMessage){
        System.out.println("点对点:"+mqMessage);
    }

    /** 点对点发送 direct */
    public void sendToDirect(RabbitMqMessage mqMessage ){
        rabbitTemplate.convertAndSend("springboot.direct","direct.queue",mqMessage);
    }


    /**  监听  springboot.topic 路由 的各个队列
     */
    @RabbitListener(queues = "huaihua")
    public void receive1(RabbitMqMessage mqMessage){
        System.out.println("怀化接收到:"+mqMessage);
    }
    @RabbitListener(queues = "changsha")
    public void receive2(RabbitMqMessage mqMessage){
        System.out.println("长沙接收到:"+mqMessage);
    }
    @RabbitListener(queues = "news")
    public void receive3(RabbitMqMessage mqMessage){
        System.out.println("新闻接收到:"+mqMessage);
    }
    @RabbitListener(queues = "wather")
    public void receive4(RabbitMqMessage mqMessage){
        System.out.println("天气接收到:"+mqMessage);
    }


    /**  给  springboot.topic 路由发送消息
     */
    public void sendTotopic(RabbitMqMessage mqMessage ){
        //可以直接传送对象，但要序列化
        rabbitTemplate.convertAndSend("springboot.topic",mqMessage.getRoutingKey(),mqMessage);
    }
}
