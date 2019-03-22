package pers.panqt.springboot.modules.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *  @time       2019年03月13日	23:31
 *	@author     panqt
 *
 *	@comment   特别注意：异步方法 和 调用方法 要 写在两个类里
 */
@Service
public class AsyncService {
    @Async
    public void async() {
        System.out.println("处理数据中...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据结束...");
    }
}
