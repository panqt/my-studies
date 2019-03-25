package pers.panqt.design.patterns._00SimpleFactory;

/**  @author panqt 2019/03/25 15:37
 *   
 */
public class SendFactory {

    //普通工厂模式
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}
