package pers.panqt.dubbo.customer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pers.panqt.dubbo.provider.api.UserService;
import pers.panqt.dubbo.provider.entry.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboCustomerApplicationTests {

    @Reference
    UserService service;

    @Test
    public void contextLoads() {
        int i = 0;
        while (true){
            i++;
            User user = service.findById(i);
            System.out.println(user);
        }

    }

}

