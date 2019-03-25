package pers.panqt.design.patterns._10Bridge;

/**  @author panqt 2019/03/25 16:30
 *   
 */
public class SourceSub1 implements Sourceable {

    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
