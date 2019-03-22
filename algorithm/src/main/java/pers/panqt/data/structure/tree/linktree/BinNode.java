package pers.panqt.data.structure.tree.linktree;

/**
 *  @time       2019年01月05日	17:49
 *	@since      V0.1
 *	@author     panqt
 *	@comment    链式二叉树节点
 */
public class BinNode {
    private int value;
    private BinNode left;
    private BinNode right;

    public BinNode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(BinNode left){
        this.left=left;
    }

    public void setRight(BinNode right){
        this.right=right;
    }

    public BinNode getLeft() {
        return left;
    }

    public BinNode getRight() {
        return right;
    }

    //前序遍历
    public void frontShow(){
        System.out.print(this.value);
        if (this.left!=null)
            left.frontShow();
        if (this.right!=null)
            right.frontShow();
    }

    //中序遍历
    public void midShow(){
        if (this.left!=null)
            left.midShow();
        System.out.print(value);
        if (this.right!=null)
            right.midShow();
    }

    //后序遍历
    public void afterShow(){
        if (this.left!=null)
            left.afterShow();
        if (this.right!=null)
            right.afterShow();
        System.out.print(value);
    }

    //前序查找
    public BinNode frontFind(int value){
        BinNode target = null;
        if(this.value == value){
            target =  this;
        }

        if (target==null && this.left!=null)
            target = left.frontFind(value);
        if (target==null && this.right!=null)
            target = right.frontFind(value);
        return target;
    }

    //前序查找删除e
    public boolean frontFindDelete(int value){
        boolean finded = false;
        if(this.value == value){
            finded = true;
        }

        if (!finded && right.left!=null) {
            finded = left.frontFindDelete(value);
            left.setLeft(null);
        }
        if (!finded && right.right!=null) {
            finded = right.frontFindDelete(value);
            right.setRight(null);
        }
        return finded;
    }
}
