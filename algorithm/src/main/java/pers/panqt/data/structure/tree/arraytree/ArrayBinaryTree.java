package pers.panqt.data.structure.tree.arraytree;

/**
 *  @time       2019年01月05日	19:27
 *	@since      V0.1
 *	@author     panqt
 *	@comment    顺序存储二叉树
 *
 *  第n个(从0开始)元素左子节点：2n+1
 *                  右子节点：2n+2
 *                  父节点：(n-1)/2
 */
public class ArrayBinaryTree {
    public static void main(String[] args) {
        int[]  data = new int[]{0,1,2,3,4,5,6,7,8,9};
        ArrayBinaryTree arrayBinaryTree = new  ArrayBinaryTree(data);

        arrayBinaryTree.frontShow();
    }


    int[]  data;
    public ArrayBinaryTree(int[]  data){
        this.data=data;
    }

    public void frontShow(){
        frontShow(0);
    }

    public void frontShow(int index){
        if (data==null || data.length==0){
            return;
        }

        System.out.print(data[index]);
        if (index*2+1<data.length)
            frontShow(data[index*2+1]);
        if (index*2+2<data.length)
            frontShow(data[index*2+2]);
    }
}
