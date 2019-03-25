package pers.panqt.design.patterns._23Interpreter;

/**  @author panqt 2019/03/25 17:49
 *   
 */
public class Run {
    public static void main(String[] args) {

        // 计算9+2-8的值
        int result = new Minus().interpret((new Context(new Plus()
                .interpret(new Context(9, 2)), 8)));
        System.out.println(result);
    }
}
