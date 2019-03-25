package pers.panqt.design.patterns._14TemplateMethod;

/**  @author panqt 2019/03/25 16:57
 *   
 */
/**@Slf4j*/
public class Run {

    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}
