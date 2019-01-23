package pers.panqt.data.structure.tree.sorttree;

/**
 *  @time       2019年01月08日	22:54
 *	@since      V0.1
 *	@author     panqt
 *	@comment    二叉排序树
 */
public class BinarySortTree {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        int[] arr = {4,2,6,7,5,3,1};
        for (int i: arr) {
            Node node = new Node(i);
            binarySortTree.add(node);
        }
              binarySortTree.midShow();
        binarySortTree.add(new Node(8));
        binarySortTree.midShow();

        Node find = binarySortTree.search(6);
        System.out.println(find.getValue());

        Node parent = binarySortTree.searchParent(8);
        System.out.println(parent.getValue());

        binarySortTree.delete(4);
        binarySortTree.midShow();
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
