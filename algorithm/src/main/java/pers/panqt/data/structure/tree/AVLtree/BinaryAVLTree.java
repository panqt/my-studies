package pers.panqt.data.structure.tree.AVLtree;

/**
 *  @time       2019年01月24日	0:36
 *	@since      V0.1
 *	@author     panqt
 *	@comment    平衡二叉树
 */
public class BinaryAVLTree {
    public static void main(String[] args) {
        //测试右旋转
        BinaryAVLTree binarySortTree = new BinaryAVLTree();
        int[] arr = {8,6,9,5,7,4};
        for (int i: arr) {
            Node node = new Node(i);
            binarySortTree.add(node);
        }
        int hight = binarySortTree.root.hight();
        System.out.println("hight:"+hight);
        binarySortTree.midShow();


        //测试左旋转
        BinaryAVLTree binarySortTree2 = new BinaryAVLTree();
        int[] arr2 = {2,1,4,3,5,6};
        for (int i: arr2) {
            Node node = new Node(i);
            binarySortTree2.add(node);
        }
        int hight2 = binarySortTree2.root.hight();
        System.out.println("hight2:"+hight2);
        binarySortTree2.midShow();

        //测试右双旋转
        BinaryAVLTree binarySortTree3 = new BinaryAVLTree();
        int[] arr3 = {8,9,5,4,6,7};
        for (int i: arr3) {
            Node node = new Node(i);
            binarySortTree3.add(node);
        }
        int hight3 = binarySortTree3.root.hight();
        System.out.println("hight3:"+hight3);
        binarySortTree3.midShow();

    }

    private void delete(int value) {
        System.out.println("===删除"+value+"===");
        Node target = search(value);
        Node parent = searchParent(value);

        if(target.getLeft()==null && target.getRight()==null){
            //目标为叶子节点
            if(parent.getRight().getValue() == value){
                parent.setRight(null);
            }else {
                parent.setLeft(null);
            }
        }else if(target.getLeft()!=null && target.getRight()!=null){
            //目标有两个子节点
            //把后驱节点移到本节点,即右侧最小值
            int min = deleteMin(target.getRight());
            target.setValue(min);

        }else {
            //目标有一个子节点
            if(parent.getRight().getValue() == value){
                if(target.getRight()!=null){
                    parent.setRight(target.getRight());
                }else {
                    parent.setRight(target.getLeft());
                }
            }else {
                if(target.getRight()!=null){
                    parent.setLeft(target.getRight());
                }else {
                    parent.setLeft(target.getLeft());
                }
            }
        }
    }

    private Node searchParent(int value) {
        return root.searchParent(value);
    }

    private Node search(int value) {
        return root.search(value);
    }


    private Node root;

    private void midShow() {
        root.midshow(root);
        System.out.println("\n====");
    }

    public void add(Node node){
        if(root == null){
            root=node;
        }else {
            root.add(node);
        }
    }

    public int deleteMin(Node node) {
        if(node.getLeft()!=null){
            return deleteMin(node.getLeft());
        }else {
            delete(node.getValue());
            return node.getValue();
        }

    }
}
