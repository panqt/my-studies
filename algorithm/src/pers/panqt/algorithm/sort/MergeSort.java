package pers.panqt.algorithm.sort;

import java.util.Arrays;

/**
 *  @time       2019年01月05日	4:39
 *	@since      V0.1
 *	@author     panqt
 *	@comment    归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,7,2,5,8,9,2,3,4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr){
        long l1 = System.currentTimeMillis();
        sort(arr,0,arr.length-1);
        long l2 = System.currentTimeMillis();
        System.out.println("归并排序时间："+(l2-l1));
        return arr;
    }

    private static int[] sort(int[] arr,int start,int high){
        int mid = (high+start)/2;
        if(start<high){
            sort(arr,start,mid);
            sort(arr,mid+1,high);
            merge(arr,start,mid,high);
        }
        return arr;
    }

    private static int[] merge(int[] arr,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int index = 0;

        int left = low;
        int right = mid+1;

        while (left<=mid && right<=high){
            if(arr[left]<arr[right]){
               temp[index] = arr[left];
               left++;
            }else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }
        while (left<=mid){
            temp[index] = arr[left];
            left++;
            index++;
        }
        while (right<=high){
            temp[index] = arr[right];
            right++;
            index++;
        }

        for (int k=0;k<temp.length;k++){
            arr[k+low] = temp[k];
        }

        return arr;
    }
}
