package pers.panqt.data.structure;

import java.util.Arrays;

/**
 *  @time       2019年01月02日	4:07
 *	@since      V0.1
 *	@author     panqt
 *	@comment    栈
 */
public class Stack {

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
