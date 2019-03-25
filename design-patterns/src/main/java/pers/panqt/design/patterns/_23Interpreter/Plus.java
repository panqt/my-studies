package pers.panqt.design.patterns._23Interpreter;

/**  @author panqt 2019/03/25 17:48
 *   
 */
public class Plus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1()+context.getNum2();
    }
}
