package pers.panqt.algorithm.sort;

import java.util.Arrays;

/**
 *  @time       2019年01月05日	3:29
 *	@since      V0.1
 *	@author     panqt
 *	@comment    希尔排序（解决插入排序后面出现小数问题）
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,7,8,9,2,0,3,4,6};
        arr = shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] shellSort(int[] arr){
        long l1 = System.currentTimeMillis();
        //基准数
        int datum;

        //步数
        for(int step = arr.length/2;step>0;step/=2){
            for(int i=step;i<arr.length;i+=step){
                datum = arr[i];
                for(int j=i-step;j>=0;j-=step){
                    if(datum<arr[j]){
                        arr[j+step]=arr[j];
                        if(j==0){
                            arr[0]=datum;
                        }
                    }else {
                        arr[j+step]=datum;
                        break;
                    }
                }
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("希尔排序时间："+(l2-l1));
        return arr;
    }
}
