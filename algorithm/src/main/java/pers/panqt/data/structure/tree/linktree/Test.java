package pers.panqt.data.structure.tree.linktree;

/**
 *  @time       2019年01月05日	17:52
 *	@since      V0.1
 *	@author     panqt
 *	@comment    链式二叉树
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = initBinaryTree();

        binaryTree.frontShow();
        binaryTree.midShow();
        binaryTree.afterShow();

        BinNode binNode = binaryTree.frontFind(1);

        binaryTree.delete(0);
    }

    /*         0
    *        1   2
    *      3  4 5  6
    * */
    private static BinaryTree initBinaryTree(){
        BinaryTree binaryTree = new BinaryTree();
        BinNode root = new BinNode(0);
        BinNode l = new BinNode(1);
        BinNode r = new BinNode(2);
        BinNode ll = new BinNode(3);
        BinNode lr = new BinNode(4);
        BinNode rl = new BinNode(5);
        BinNode rr = new BinNode(6);

        binaryTree.setRoot(root);
        root.setLeft(l);
        root.setRight(r);
        l.setRight(r);
        l.setLeft(ll);
        l.setRight(lr);
        r.setLeft(rl);
        r.setRight(rr);

        return binaryTree;
    }
}
