package pers.panqt.design.patterns._13Strategy;

/**  @author panqt 2019/03/25 16:53
 *   
 */
/**@Slf4j*/
public class Run {
    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
