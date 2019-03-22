package pers.panqt.algorithm.recursive;

/**
 *  @time       2019年01月02日	18:47
 *	@since      V0.1
 *	@author     panqt
 *	@comment    汉诺塔问题
 */
public class Hanoi {

    public static void main(String[] args) {
        new Hanoi().hanoi(3,'A','B','C');
    }
    /**
     * @param n 共有几个盘子
     * @param from 盘子所在柱子
     * @param in 中间柱子
     * @param target 目标柱子
     * */
    private void hanoi(int n,char from,char in,char target){
        if(n == 1){//只有一个盘子
            System.out.println("盘子 1 从"+from+"移动到"+target);
        }else {//无论有多少盘子，都认为只有两个，上面所有和下面一个

            //移动上面所有盘子到中间位置
            hanoi(n-1,from,target,in);

            //移动下面的盘子
            System.out.println("盘子 "+n+" 从"+from+"移动到"+target);

            //把上面所有盘子从中间移动到目标位置
            hanoi(n-1,in,from,target);
        }
    }
}
