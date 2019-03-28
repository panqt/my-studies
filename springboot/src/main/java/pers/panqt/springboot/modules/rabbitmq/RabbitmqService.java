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
        amqpAdmin.declareExchange(new DirectExchange("custom.springboot.direct"));
        amqpAdmin.declareQueue(new Queue("custom.queue.direct",true));
        amqpAdmin.declareBinding(new Binding("custom.queue.direct", Binding.DestinationType.QUEUE , "custom.springboot.direct", "direct.queue", null));

        /** topic : 话题模式.    路由(Exchange) 按路由键(RoutingKey)匹配,把接收到的消息，分发到多个队列
         *                      比如接受到消息的 RoutingKey 是 huaihua.news
         *                      这个 RoutingKey 匹配 怀化(huaihua.*) 和 新闻(*.news) 两个队列，就会把消息发送给两个队列
         *
         *                      * 可以代替一个任意标识符 ；# 可以代替零个或多个标识符
         * */
        amqpAdmin.declareExchange(new TopicExchange("custom.springboot.topic"));
        amqpAdmin.declareQueue(new Queue("custom.queue.huaihua",true));
        amqpAdmin.declareQueue(new Queue("custom.queue.changsha",true));
        amqpAdmin.declareQueue(new Queue("custom.queue.news",true));
        amqpAdmin.declareQueue(new Queue("custom.queue.wather",true));
        amqpAdmin.declareBinding(new Binding("custom.queue.huaihua", Binding.DestinationType.QUEUE , "custom.springboot.topic", "huaihua.*", null));
        amqpAdmin.declareBinding(new Binding("custom.queue.changsha", Binding.DestinationType.QUEUE , "custom.springboot.topic", "changsha.*", null));
        amqpAdmin.declareBinding(new Binding("custom.queue.news", Binding.DestinationType.QUEUE , "custom.springboot.topic", "*.news", null));
        amqpAdmin.declareBinding(new Binding("custom.queue.wather", Binding.DestinationType.QUEUE , "custom.springboot.topic", "*.wather", null));

    }

    /**  监听rcustom.queue.direct队列
     */
    @RabbitListener(queues = "custom.queue.direct")
    public void receive(RabbitMqMessage mqMessage){
        System.out.println("点对点:"+mqMessage);
    }

    /** 点对点发送 direct */
    public void sendToDirect(RabbitMqMessage mqMessage ){
        rabbitTemplate.convertAndSend("custom.springboot.direct","direct.queue",mqMessage);
    }


    /**  监听  custom.springboot.topic 路由 的各个队列
     */
    @RabbitListener(queues = "custom.queue.huaihua")
    public void receive1(RabbitMqMessage mqMessage){
        System.out.println("怀化接收到:"+mqMessage);
    }
    @RabbitListener(queues = "custom.queue.changsha")
    public void receive2(RabbitMqMessage mqMessage){
        System.out.println("长沙接收到:"+mqMessage);
    }
    @RabbitListener(queues = "custom.queue.news")
    public void receive3(RabbitMqMessage mqMessage){
        System.out.println("新闻接收到:"+mqMessage);
    }
    @RabbitListener(queues = "custom.queue.wather")
    public void receive4(RabbitMqMessage mqMessage){
        System.out.println("天气接收到:"+mqMessage);
    }


    /**  给  custom.springboot.topic 路由发送消息
     */
    public void sendTotopic(RabbitMqMessage mqMessage ){
        //可以直接传送对象，但要序列化
        rabbitTemplate.convertAndSend("custom.springboot.topic",mqMessage.getRoutingKey(),mqMessage);
    }
}
