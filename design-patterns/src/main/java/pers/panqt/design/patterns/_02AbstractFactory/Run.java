package pers.panqt.design.patterns._02AbstractFactory;

/**  @author panqt 2019/03/25 15:45
 *   
 */
/**@Slf4j*/
public class Run {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
