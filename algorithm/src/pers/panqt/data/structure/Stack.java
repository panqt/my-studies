package pers.panqt.data.structure;


/**
 *  @time       2019年01月02日	4:07
 *	@since      V0.1
 *	@author     panqt
 *	@comment    栈
 */
public class Stack {

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



    private int[] arr = new int[0];

    //压栈
    public void push(int element){
        int[] newArr = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            newArr[i] = arr[i];
        }
        newArr[newArr.length-1] = element;
        arr = newArr;
    }

    //出栈
    public int pop(){
        int retValue = arr[arr.length-1];
        int[] newArr = new int[arr.length-1];
        for(int i=0;i<newArr.length;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
        return retValue;
    }

    //查看
    public int peek(){
        return arr[arr.length-1];
    }
}
