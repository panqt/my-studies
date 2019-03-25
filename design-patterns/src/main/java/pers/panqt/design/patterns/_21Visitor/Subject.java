package pers.panqt.design.patterns._21Visitor;

/**  @author panqt 2019/03/25 17:36
 *   
 */
public interface Subject {
    public void accept(Visitor visitor);
    public String getSubject();
}
