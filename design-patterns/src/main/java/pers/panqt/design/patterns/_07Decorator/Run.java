package pers.panqt.design.patterns._07Decorator;

/**  @author panqt 2019/03/25 16:22
 *   
 */
public class Run {
    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
