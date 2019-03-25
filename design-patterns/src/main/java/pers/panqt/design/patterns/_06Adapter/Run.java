package pers.panqt.design.patterns._06Adapter;

/**  @author panqt 2019/03/25 16:07
 *   
 */
public class Run {
    public static void main(String[] args) {
        //类的适配器模式
        Targetable target = new Adapter();
        target.method1();
        target.method2();

        //对象的适配器模式
        Source source = new Source();
        Targetable target2 = new Wrapper(source);
        target2.method1();
        target2.method2();

        //接口的适配器模式
        Targetable targetable1 = new TargetSub1();
        Targetable targetable2 = new TargetSub2();
        targetable1.method1();
        targetable1.method2();
        targetable2.method1();
        targetable2.method2();
    }
}
