package pers.panqt.design.patterns._04Builder;

/**  @author panqt 2019/03/25 17:59
 *   
 */
public class Run {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }

}
