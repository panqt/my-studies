package pers.panqt.data.structure.tree.threadedtree;

/**
 *  @time       2019年01月05日	17:49
 *	@since      V0.1
 *	@author     panqt
 *	@comment
 */
public class BinNode {
    private int value;
    private BinNode left;
    private BinNode right;
    private int leftType;
    private int rightType;

    public BinNode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinNode getLeft() {
        return left;
    }

    public void setLeft(BinNode left) {
        this.left = left;
    }

    public BinNode getRight() {
        return right;
    }

    public void setRight(BinNode right) {
        this.right = right;
    }


    BinNode pre=null;
    //中序线索化
    public void midThread(BinNode node){
        if(node==null)return;

        if(node.left!=null){
            midThread(node.left);
        }else {
            node.left=pre;
            node.leftType=1;
        }
        if(pre!=null && pre.right==null){
            pre.right=node;
            pre.rightType=1;
        }
        pre=node;

        if(node.right!=null){
            midThread(node.right);
        }
    }

    //中序遍历
    public void midShow(BinNode root){
        BinNode node = root;
        while (node!=null){
            while (node.leftType==0){
                node=node.left;
            }
            System.out.print(node.value);

            while (node.rightType==1){
                node=node.right;
                System.out.print(node.value);
            }

            node=node.right;
        }


    }

    @Override
    public String toString() {
        return value+"";
    }
}
