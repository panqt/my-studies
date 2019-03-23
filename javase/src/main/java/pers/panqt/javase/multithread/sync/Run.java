package pers.panqt.javase.multithread.sync;

import lombok.extern.slf4j.Slf4j;

/**  @author panqt 2019/03/22 22:13
 *   线程同步
 */
@Slf4j
public class Run {
    public static void main(String[] args){
        Sync sync = new Sync();
        new Thread(sync,"A").start();
        new Thread(sync,"B").start();
        new Thread(sync,"C").start();
        new Thread(sync,"D").start();

        //new Async("A").start();
        //new Async("B").start();
        //new Async("C").start();
        //new Async("D").start();
    }
}

class Async extends Thread{

    /**     数据不同步
     *      遇到 线程不安全问题：
     *      各个线程各自玩各自的
     * */

    private int count = 0;

    public Async(String name){
        super(name);
    }

    @Override
    public void run() {
        while (count<20){
            count++;
            System.out.println(Thread.currentThread().getName() + "计算的" + count);
        }
    }
}

class  Sync extends Thread{

    /**     数据同步
     *      synchronized 给代码块加锁
     */

    private int count = 0;

    @Override
    synchronized public void run() {
        count++;
        System.out.println(Thread.currentThread().getName() + "计算的" + count);
    }
}