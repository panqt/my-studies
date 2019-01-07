package pers.panqt.data.structure.tree.threadedtree;

/**
 *  @time       2019年01月07日	3:31
 *	@since      V0.1
 *	@author     panqt
 *	@comment    线索二叉树
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        BinNode binNode = initBinaryTree();
        binNode.midThread(binNode);
        binNode.midShow(binNode);
    }


    /*         0
     *        1   2
     *      3  4 5  6
     * */
    private static BinNode initBinaryTree(){
        BinNode root = new BinNode(0);
        BinNode l = new BinNode(1);
        BinNode r = new BinNode(2);
        BinNode ll = new BinNode(3);
        BinNode lr = new BinNode(4);
        BinNode rl = new BinNode(5);
        BinNode rr = new BinNode(6);

        root.setLeft(l);
        root.setRight(r);
        l.setLeft(ll);
        l.setRight(lr);
        r.setLeft(rl);
        r.setRight(rr);

        return root;
    }
}
