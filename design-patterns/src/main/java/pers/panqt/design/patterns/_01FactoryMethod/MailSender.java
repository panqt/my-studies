package pers.panqt.design.patterns._01FactoryMethod;

/**  @author panqt 2019/03/25 15:36
 *   
 */
public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
}
