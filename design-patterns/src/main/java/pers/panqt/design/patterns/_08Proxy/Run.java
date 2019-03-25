package pers.panqt.design.patterns._08Proxy;


/**  @author panqt 2019/03/25 16:22
 *   
 */
public class Run {
    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }
}
