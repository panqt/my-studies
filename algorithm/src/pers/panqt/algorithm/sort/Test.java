package pers.panqt.algorithm.sort;

import java.util.Arrays;
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

        int[] arr = new int[100000];
        for (int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(1000000);
        }

        int[] arr1 = Arrays.copyOf(arr,arr.length);
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        int[] arr3 = Arrays.copyOf(arr,arr.length);
        int[] arr4 = Arrays.copyOf(arr,arr.length);
        BubbleSort.bubbleSort(arr1);
        QuickSort.quickSort(arr2,0,arr.length-1);
        InsertSort.insertSort(arr3);
        ShellSort.shellSort(arr4);
    }
}
