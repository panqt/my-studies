package pers.panqt.design.patterns._01FactoryMethod;

/**  @author panqt 2019/03/25 15:37
 *   
 */
public class SendFactory {
    //多个静态工厂方法模式
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}
