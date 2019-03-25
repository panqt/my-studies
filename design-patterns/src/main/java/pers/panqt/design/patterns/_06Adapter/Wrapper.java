package pers.panqt.design.patterns._06Adapter;

/**  @author panqt 2019/03/25 16:09
 *   对象的适配器模式
 */
public class Wrapper implements Targetable {
    private Source source;

    public Wrapper(Source source){
        super();
        this.source = source;
    }
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}
