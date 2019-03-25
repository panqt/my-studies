package pers.panqt.design.patterns._10Bridge;

/**  @author panqt 2019/03/25 16:31
 *   
 */
public class MyBridge extends Bridge {
    @Override
    public void method(){
        getSource().method();
    }
}
