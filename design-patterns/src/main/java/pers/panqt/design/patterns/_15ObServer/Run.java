package pers.panqt.design.patterns._15ObServer;

/**  @author panqt 2019/03/25 17:01
 *   
 */
public class Run {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
