package pers.panqt.algorithm.sort;

import java.util.Arrays;

/**
 *  @time       2019年01月02日	19:40
 *	@since      V0.1
 *	@author     panqt
 *	@comment    冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{5,1,7,2,5,8,9,2,3,4};
        arr = bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**5,1,7,2,5,8,9,2,3,4
     * 1,5,7,2,5,8,9,2,3,4
     * 1,5,7,2,5,8,9,2,3,4
     * 1,5,2,7,5,8,9,2,3,4
     * ...
     * 1,5,2,5,7,8,2,3,4,9
     * */
    public static int[] bubbleSort(int[] arr){
        long l1 = System.currentTimeMillis();

        //一共要比较n-1轮，最后一个（或本身）不需要比较
        for(int i=0;i<arr.length-1;i++){

            //每轮比较的次数，已经冒泡到最后的可以不比较，不比较的个数为已比较的轮数
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }

        long l2 = System.currentTimeMillis();
        System.out.println("冒泡排序时间："+(l2-l1));
        return arr;

    }
}
