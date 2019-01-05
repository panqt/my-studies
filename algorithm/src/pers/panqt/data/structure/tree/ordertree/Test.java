package pers.panqt.data.structure.tree.ordertree;

/**
 *  @time       2019年01月05日	19:17
 *	@since      V0.1
 *	@author     panqt
 *	@comment    顺序存储二叉树
 *
 *  第n个元素左子节点：2n+1
 *          右子节点：2n+2
 *          父节点：(n-1)/2
 */
public class Test {
    public static void main(String[] args) {
        int[]  data = new int[]{0,1,2,3,4,5,6,7,8,9};
        ArrayBinaryTree arrayBinaryTree = new  ArrayBinaryTree(data);

        arrayBinaryTree.frontShow();
    }
}
