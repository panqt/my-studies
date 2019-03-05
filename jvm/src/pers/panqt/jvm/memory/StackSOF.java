package pers.panqt.jvm.memory;

/**
 *  @time       2019年02月05日	18:01
 *	@author     panqt
 *
 *	@comment    方法栈溢出
 *              vm args：-Xss128k
 *  @throws     StackOverflowError
 */
public class StackSOF {
    public static void main(String[] args) {
        StackSOF stackSOF = new StackSOF();

        try {
            stackSOF.stackLeak();
        } catch (Throwable e){
            System.out.println("stackLength:"+stackSOF.stackLength);
            throw e;
        }
    }

    int stackLength = 0;

    private void stackLeak(){
        stackLength++;
        stackLeak();
    }
}
