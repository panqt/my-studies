package pers.panqt.algorithm.sort;

import java.util.Random;

/**
 *  @time       2019年01月02日	20:37
 *	@since      V0.1
 *	@author     panqt
 *	@comment    
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();

        int[] arr = new int[10000];
        for (int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(100000);
        }

        BubbleSort.bubbleSort(arr);
        QuickSort.quickSort(arr,0,arr.length-1);
    }
}
