package pers.panqt.algorithm.search;

/**
 *  @time       2019年01月02日	3:28
 *	@since      V0.1
 *	@author     panqt
 *	@comment    二分查找
 */
public class BinaryChop {

    private int begin = 0;
    private int end = 0;
    private int mid = 0;

    private int index = -1;

    public int search(int target,int[] arr){
        long startTime = System.currentTimeMillis();

        end = arr.length-1;
        mid = (begin + end)/2;

        if(arr[0]<=arr[arr.length-1]){//正序数组
            while (true){
                if(arr[mid] == target){
                    index = mid;//查询到
                    break;
                }else {
                    if(begin >= end){
                        break;
                    }else if(arr[mid]>target){
                        end = mid-1;
                    }else {
                        begin = mid+1;
                    }
                }
                mid = (begin + end)/2;
            }
        }else {//倒序数组
            while (true){
                if(arr[mid] == target){
                    index = mid;//查询到
                    break;
                }else {
                    if(begin >= end){
                        break;
                    }else if(arr[mid]>target){
                        begin = mid+1;
                    }else {
                        end = mid-1;
                    }
                }
                mid = (begin + end)/2;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("二分查找查询到 "+target+" 的位置:"+index);
        System.out.println("二分查找时间:"+(endTime-startTime));
        return index;
    }
}
