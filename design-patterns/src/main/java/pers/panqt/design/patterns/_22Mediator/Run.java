package pers.panqt.design.patterns._22Mediator;

/**  @author panqt 2019/03/25 17:43
 *   
 */
public class Run {
    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}
