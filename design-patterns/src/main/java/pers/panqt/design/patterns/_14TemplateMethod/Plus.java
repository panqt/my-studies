package pers.panqt.design.patterns._14TemplateMethod;

/**  @author panqt 2019/03/25 16:57
 *   
 */
public class Plus extends AbstractCalculator {

    @Override
    public int calculate(int num1,int num2) {
        return num1 + num2;
    }
}
