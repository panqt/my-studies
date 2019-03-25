package pers.panqt.design.patterns._02AbstractFactory;

/**  @author panqt 2019/03/25 15:42
 *   
 */
public class SendMailFactory implements Provider {

    @Override
    public Sender produce(){
        return new MailSender();
    }
}
