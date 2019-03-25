package pers.panqt.design.patterns._06Adapter;

/**  @author panqt 2019/03/25 16:15
 *   
 */
public class TargetSub2 extends Wrapper2{
    @Override
    public void method2(){
        System.out.println("the sourceable interface's second Sub2!");
    }
}
