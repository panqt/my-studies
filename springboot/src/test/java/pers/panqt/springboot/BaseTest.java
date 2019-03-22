package pers.panqt.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.ResultVo;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    @Test
    public void test(){
        List<String> strings = new ArrayList<>();
        for (String string : strings) {

        }
    }
}

