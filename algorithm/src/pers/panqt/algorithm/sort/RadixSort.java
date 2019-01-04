package pers.panqt.algorithm.sort;

import pers.panqt.data.structure.Queue;

import java.util.Arrays;

/**
 *  @time       2019年01月05日	6:15
 *	@since      V0.1
 *	@author     panqt
 *	@comment    基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{15,31,117,422,125,748,39,92,53,414};
        int[] arr1 = new int[]{15,31,117,422,125,748,39,92,53,414};
        radixSort(arr);
        radixQueueSort(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }

    public static  int[] radixSort(int[] arr){
        long l1 = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        int maxLength = (max+"").length();
        int[][] temp = null;
        int[] index =null;
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            temp = new int[10][arr.length];
            index = new int[10];
            for(int j=0;j<arr.length;j++){
                int ys = arr[j]/n%10;

                temp[ys][index[ys]] = arr[j];
                index[ys]++;
            }

            int arrindex = 0;
            for(int k=0;k<10;k++){
                for(int y=0;y<index[k];y++){
                    arr[arrindex] = temp[k][y];
                    arrindex++;
                }
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("基数排序时间："+(l2-l1));
        return arr;
    }


    //队列
    public static  int[] radixQueueSort(int[] arr){
        long l1 = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        int maxLength = (max+"").length();
        Queue[] temp = temp = new Queue[10];
        for(int i=0;i<temp.length;i++){
            temp[i]=new Queue();
        }
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            for(int j=0;j<arr.length;j++){
                int ys = arr[j]/n%10;

                temp[ys].add(arr[j]);
            }

            int arrindex = 0;
            for(int k=0;k<10;k++){
                while (temp[k].isNotEmpty()){
                    arr[arrindex] = temp[k].poll();
                    arrindex++;
                }
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("基数排序时间："+(l2-l1));
        return arr;
    }

}
