package pers.panqt.springboot.async;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;

/**
 *  @time       2019年03月18日	2:07
 *	@author     panqt
 *
 *	@comment    异步
 */
public class AsyncTest extends BaseTest {

    @Autowired
    AsyncService asyncService;

    @Test
    public void async(){

        logger("开始调用异步。。。。");
        asyncService.async();
        logger("结束调用异步。。。。");

    }
}
