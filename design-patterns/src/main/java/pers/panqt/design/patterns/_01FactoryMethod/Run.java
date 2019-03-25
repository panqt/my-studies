package pers.panqt.design.patterns._01FactoryMethod;

/**  @author panqt 2019/03/25 15:37
 *   
 */

/**@Slf4j*/
public class Run {
    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }
}
