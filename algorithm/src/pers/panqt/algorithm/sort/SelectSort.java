package pers.panqt.algorithm.sort;

import java.util.Arrays;

/**
 *  @time       2019年01月05日	4:07
 *	@since      V0.1
 *	@author     panqt
 *	@comment    选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,7,8,9,2,0,3,4,6};
        arr = selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] selectSort(int[] arr){
        long l1 = System.currentTimeMillis();

        int min;
        int minIndex;
        for(int i=0;i<arr.length;i++){
            minIndex = i;
            min = arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            }
            arr[minIndex]=arr[i];
            arr[i]=min;
        }

        long l2 = System.currentTimeMillis();
        System.out.println("选择排序时间："+(l2-l1));
        return arr;
    }
}
