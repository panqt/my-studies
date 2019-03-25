package pers.panqt.design.patterns._00SimpleFactory;

/**  @author panqt 2019/03/25 15:37
 *   
 */
/**@Slf4j*/
public class Run {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
    }
}
