package pers.panqt.springboot.modules.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.RabbitMqMessage;
import pers.panqt.springboot.modules.rabbitmq.RabbitmqService;

/**  @auther panqt 2019/03/21 23:02
 */
@Slf4j
public class RabbitMqTest extends BaseTest {

    @Autowired
    private RabbitmqService rabbitmqService;

    /** 测试 {@link RabbitmqService#sendToDirect(RabbitMqMessage)}*/
    @Test
    public void sendToDirect() {
        for (int i = 0; i < 1; i++) {
            //try {
            //    Thread.sleep(50);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            rabbitmqService.sendToDirect(new RabbitMqMessage("点对点的消息"+i));
        }
    }



    /** 测试 {@link RabbitmqService#sendTotopic(RabbitMqMessage)}*/
    @Test
    public void sendTotopic() {
        sendMessage("怀化有个大新闻", "huaihua.news");
    }
    @Test
    public void sendTotopic2() {
        sendMessage("长沙有个屁", "changsha.1");
    }
    @Test
    public void sendTotopic3() {
        sendMessage("广州下暴雨", "guangzhou.wather");
    }

    private void sendMessage(String meassage,String routingKey){
        for (int i = 0; i < 1; i++) {
            //try {
            //    Thread.sleep(50);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            rabbitmqService.sendTotopic(new RabbitMqMessage(meassage+i,routingKey));
        }
    }

}
