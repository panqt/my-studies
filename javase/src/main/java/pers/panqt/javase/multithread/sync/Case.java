package pers.panqt.javase.multithread.sync;

import lombok.extern.slf4j.Slf4j;

/**  @author panqt 2019/03/22 22:44
 *   线程不安全 案例
 */
@Slf4j
public class Case {
    public static void main(String[] args){
        new CaseThreadA().start();
        new CaseThreadB().start();
    }
}

class CaseThreadA extends Thread{

    @Override
    public void run() {
        CaseService.set("a","aa");
    }
}
class CaseThreadB extends Thread{

    @Override
    public void run() {
        CaseService.set("b","bb");
    }
}

class CaseService{
    static String ACC;
    static String PWD;


    /** 不加同步锁，会出现
     *  b-bb
     *  b-aa
     */


    /*synchronized*/ static void set(String acc,String pwd){
        try {
            ACC=acc;
            if(acc.equals("a")){
                Thread.sleep(1000);
            }
            PWD=pwd;
            System.out.println(ACC + "-" + PWD);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}