package pers.panqt.design.patterns._06Adapter;

/**  @author panqt 2019/03/25 16:05
 *   类的适配器模式
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
