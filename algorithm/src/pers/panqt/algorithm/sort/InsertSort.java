package pers.panqt.algorithm.sort;

import java.util.Arrays;

/**
 *  @time       2019年01月05日	2:44
 *	@since      V0.1
 *	@author     panqt
 *	@comment    插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,7,8,9,2,0,3,4,6};
        arr = insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] insertSort(int[] arr){
        long l1 = System.currentTimeMillis();
        //基准数
        int datum;

        for(int i=1;i<arr.length;i++){//依次取次基准数
            datum = arr[i];
            for(int j=i-1;j>=0;j--){//与前面的数进行对比
                if(datum<arr[j]){
                    arr[j+1]=arr[j];
                    if(j==0){
                        arr[0]=datum;
                    }
                }else {
                    arr[j+1]=datum;
                    break;
                }
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("插入排序时间："+(l2-l1));
        return arr;
    }
}
