package pers.panqt.design.patterns._17ChainOfResponsibility;

/**  @author panqt 2019/03/25 17:15
 *   
 */
public class Run {
    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");

        h1.setHandler(h2);
        h2.setHandler(h3);

        h1.operator();
    }
}
