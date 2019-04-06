package pers.panqt.java.core.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**  @author panqt 2019/04/05 18:25
 *   
 */
@Slf4j
public class SemaphoreCase implements Runnable{

    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args)throws Exception{
        new Thread(new SemaphoreCase(),"A").start();
        new Thread(new SemaphoreCase(),"B").start();
        new Thread(new SemaphoreCase(),"C").start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            //允许这段代码能有几个线程并发执行

            System.out.println("start:"+Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("end:"+Thread.currentThread().getName());

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
