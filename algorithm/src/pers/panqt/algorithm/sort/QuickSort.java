package pers.panqt.algorithm.sort;

import java.util.Arrays;

/**
 *  @time       2019年01月02日	20:07
 *	@since      V0.1
 *	@author     panqt
 *	@comment    快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,7,8,9,2,0,3,4,6};
        arr = quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] quickSort(int[] arr){
        long l1 = System.currentTimeMillis();
        arr = sort(arr,0,arr.length-1);
        long l2 = System.currentTimeMillis();
        System.out.println("快速排序时间："+(l2-l1));
        return arr;
    }
    private static int[] sort(int[] arr,int start,int end){
        if(start<end) {
            //基准数
            int datum = arr[start];


            //记录移动下标
            int low = start;
            int high = end;

            //循环找出比基准数大的和小的数
            while (low < high) {
                //右边的数字比基准数大
                while (low < high && arr[high] >= datum) {
                    high--;
                }
                //使用右边的数字替换左边的数
                arr[low] = arr[high];

                //左边的数字比基准数小
                while (low < high && arr[low] <= datum) {
                    low++;
                }
                arr[high] = arr[low];
            }

            //赋值基准数
            arr[low] = datum;
            sort(arr,start,low);
            sort(arr,low+1,end);
        }
        return arr;
    }
}
