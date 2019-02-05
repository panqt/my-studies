package pers.panqt.dubbo.customer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.panqt.dubbo.provider.api.UserService;
import pers.panqt.dubbo.provider.entry.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboCustomerApplicationTests {

    @Reference
    UserService service;

    @Test
    public void contextLoads() {
        User user = service.findById(1);
        System.out.println(user);
    }

}

