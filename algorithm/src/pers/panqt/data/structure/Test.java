package pers.panqt.data.structure;

/**
 *  @time       2019年01月02日	4:49
 *	@since      V0.1
 *	@author     panqt
 *	@comment    
 */
public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
