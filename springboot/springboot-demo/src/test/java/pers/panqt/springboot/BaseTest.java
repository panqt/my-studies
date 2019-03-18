package pers.panqt.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    public static void logger(Object x){
        System.out.println(x);
    }

    public static void logger(){
        System.out.println();
    }

    @Test
    public void test(){}
}

