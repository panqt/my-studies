package pers.panqt.design.patterns._15ObServer;

/**  @author panqt 2019/03/25 17:01
 *   
 */
public class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }

}
