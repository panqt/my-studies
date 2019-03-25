package pers.panqt.design.patterns._04Builder;

/**  @author panqt 2019/03/25 15:37
 *   
 */

public class SmsSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
