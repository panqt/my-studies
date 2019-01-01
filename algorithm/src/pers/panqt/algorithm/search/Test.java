package pers.panqt.algorithm.search;

/**
 *  @time       2019年01月02日	2:29
 *	@since      V0.1
 *	@author     panqt
 *	@comment
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("The algorithm is the most beautiful.");

        int[] arr = getArray();
        int target = 56789340;

        //二分查找
        new BinaryChop().search(target,arr);

        //线性查找
        new LinearSearch().search(target,arr);

    }


    private static int[] getArray(){
        int[] arr = new int[100000000];
        for(int i=0;i<100000000;i++){
            arr[i]=100000000-i;
        }
        return arr;
    }
}
