package pers.panqt.design.patterns._21Visitor;

/**  @author panqt 2019/03/25 17:37
 *   
 */
public class MySubject implements Subject {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}
