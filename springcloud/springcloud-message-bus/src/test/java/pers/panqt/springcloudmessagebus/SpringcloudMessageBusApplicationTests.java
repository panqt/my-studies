package pers.panqt.springcloudmessagebus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.panqt.springcloudmessagebus.service.RabbitmqService;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudMessageBusApplicationTests {

    @Autowired
    RabbitmqService rabbitmqService;

    @Test
    public void contextLoads() {
        rabbitmqService.sendToDirect("asdbasdasd");
    }

}
