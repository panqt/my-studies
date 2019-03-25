package pers.panqt.design.patterns._21Visitor;

/**  @author panqt 2019/03/25 17:36
 *   
 */
public class MyVisitor implements Visitor {

    @Override
    public void visit(Subject sub) {
        System.out.println("visit the subject："+sub.getSubject());
    }
}