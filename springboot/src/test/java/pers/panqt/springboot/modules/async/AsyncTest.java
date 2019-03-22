package pers.panqt.springboot.modules.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;

/**
 *  @time       2019年03月18日	2:07
 *	@author     panqt
 *
 *	@comment    异步
 */
@Slf4j
public class AsyncTest extends BaseTest {
    @Autowired
    AsyncService asyncService;

    @Test
    public void async(){
        System.out.println("开始异步调用。。。。");
        asyncService.async();
        System.out.println("结束异步调用。。。。");
    }
}
