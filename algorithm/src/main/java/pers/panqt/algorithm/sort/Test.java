package pers.panqt.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  @time       2019年01月02日	20:37
 *	@since      V0.1
 *	@author     panqt
 *	@comment    d
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();

        int[] arr = new int[1000];
        for (int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(2000);
        }
        int[] arr0 = Arrays.copyOf(arr,arr.length);
        int[] arr1 = Arrays.copyOf(arr,arr.length);
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        int[] arr3 = Arrays.copyOf(arr,arr.length);
        int[] arr4 = Arrays.copyOf(arr,arr.length);
        int[] arr5 = Arrays.copyOf(arr,arr.length);
        int[] arr6 = Arrays.copyOf(arr,arr.length);
        int[] arr7 = Arrays.copyOf(arr,arr.length);
        int[] arr8 = Arrays.copyOf(arr,arr.length);

        Test.systemSort(arr0);
        BubbleSort.bubbleSort(arr1);
        QuickSort.quickSort(arr2);
        InsertSort.insertSort(arr3);
        ShellSort.shellSort(arr4);
        SelectSort.selectSort(arr5);
        MergeSort.mergeSort(arr6);
        RadixSort.radixSort(arr7);
        HeapSort.heapSort(arr8);

        if(Arrays.toString(arr0).equals(Arrays.toString(arr1))
                &&Arrays.toString(arr1).equals(Arrays.toString(arr2))
                &&Arrays.toString(arr2).equals(Arrays.toString(arr3))
                &&Arrays.toString(arr3).equals(Arrays.toString(arr4))
                &&Arrays.toString(arr4).equals(Arrays.toString(arr5))
                &&Arrays.toString(arr5).equals(Arrays.toString(arr6))
                &&Arrays.toString(arr6).equals(Arrays.toString(arr7))
                &&Arrays.toString(arr7).equals(Arrays.toString(arr8))){
            System.out.println("排序正确");
        }
    }

    private static void systemSort(int[] arr0){
        long l1 = System.currentTimeMillis();
        Arrays.sort(arr0);
        long l2 = System.currentTimeMillis();
        System.out.println("系统排序时间："+(l2-l1));
    }
}
