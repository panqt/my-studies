package pers.panqt.springcloud.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.panqt.springcloud.provider.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudProviderApplicationTests {

    @Autowired
    UserService userMapper;

    @Test
    public void contextLoads() {
        System.out.println(userMapper.get(1));
    }

}
