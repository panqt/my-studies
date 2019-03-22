package pers.panqt.algorithm.recursive;

/**
 *  @time       2019年01月02日	18:34
 *	@since      V0.1
 *	@author     panqt
 *	@comment    斐波那契数列
 *              1 1 2 3 5 8 13
 */
public class Fibonacci {

    public static void main(String[] args) {
        int result = new Fibonacci().get(5);
        System.out.println(result);
    }

    //获取第n个位置的斐波那契数列
    public int get(int n){
        if(n == 1 || n == 2){
            return 1;
        }else {
            return get(n-1) + get(n-2);
        }
    }
}
