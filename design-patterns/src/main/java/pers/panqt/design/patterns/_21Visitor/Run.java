package pers.panqt.design.patterns._21Visitor;

/**  @author panqt 2019/03/25 17:37
 *   
 */
public class Run {
    public static void main(String[] args) {

        Visitor visitor = new MyVisitor();
        Subject sub = new MySubject();
        sub.accept(visitor);
    }
}
