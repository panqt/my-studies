package pers.panqt.data.structure.tree.sorttree;

/**
 *  @time       2019年01月08日	22:54
 *	@since      V0.1
 *	@author     panqt
 *	@comment    
 */
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return value+"";
    }

    public void add(Node node) {
        if(node==null){
            return;
        }

        if(this.value>node.value){
            if(this.left ==null){
                this.left = node;
            }else {
                this.left.add(node);
            }

        }else {
            if(this.right ==null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void midshow(Node node){
        if(node == null){
            return;
        }

        midshow(node.left);
        System.out.print(node.value);
        midshow(node.right);
    }

    public Node search(int value) {
        if (this.value == value){
            return this;
        }
        if(this.value>value){
            if(this.left!=null) {
                return this.left.search(value);
            }
        }else {
            if(this.right!=null) {
                return this.right.search(value);
            }
        }
        return null;
    }


    public Node searchParent(int value) {
        if((this.left!=null && this.left.value == value)
                || (this.right!=null && this.right.value == value)){
            return this;
        }else {
            if(this.value>value && this.left!=null){
                return this.left.searchParent(value);
            }else if(this.value<value && this.right!=null){
                return this.right.searchParent(value);
            }
        }
        return null;
    }
}
