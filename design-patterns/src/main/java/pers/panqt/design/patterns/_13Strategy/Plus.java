package pers.panqt.design.patterns._13Strategy;

/**  @author panqt 2019/03/25 16:52
 *   
 */
public class Plus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\+");
        return arrayInt[0]+arrayInt[1];
    }
}
