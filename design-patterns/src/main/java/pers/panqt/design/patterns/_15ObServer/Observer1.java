package pers.panqt.design.patterns._15ObServer;

/**  @author panqt 2019/03/25 17:00
 *   
 */
public class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
