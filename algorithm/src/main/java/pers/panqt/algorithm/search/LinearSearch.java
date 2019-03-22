package pers.panqt.algorithm.search;

/**
 *  @time       2019年01月02日	3:52
 *	@since      V0.1
 *	@author     panqt
 *	@comment    线性查找
 */
public class LinearSearch {

    int index = -1;

    public int search(int target,int[] arr){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                index = i;
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("线性查找查询到 "+target+" 的位置:"+index);
        System.out.println("线性查找时间:"+(endTime-startTime));
        return index;
    }
}
