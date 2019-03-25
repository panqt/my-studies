package pers.panqt.design.patterns._02AbstractFactory;

/**  @author panqt 2019/03/25 15:42
 *   
 */
public class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
