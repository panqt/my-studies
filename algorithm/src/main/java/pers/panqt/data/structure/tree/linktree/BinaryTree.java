package pers.panqt.data.structure.tree.linktree;

/**
 *  @time       2019年01月05日	17:48
 *	@since      V0.1
 *	@author     panqt
 *	@comment    二叉树
 */
public class BinaryTree {
    BinNode root;

    public BinNode getRoot() {
        return root;
    }

    public void setRoot(BinNode root) {
        this.root = root;
    }

    public void frontShow(){
        System.out.print("\n前序遍历");
        root.frontShow();
    }

    public void midShow(){
        System.out.print("\n中序遍历");
        root.midShow();
    }

    public void afterShow(){
        System.out.print("\n后序遍历");
        root.afterShow();
    }

    public BinNode frontFind(int value){
        return root.frontFind(value);
    }

    public void delete(int value){
        if(root.getValue()==value){
            root=null;
            return;
        }
        root.frontFindDelete(value);
    }
}
