package pers.panqt.data.structure.tree.AVLtree;

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
        
        //判断是否平衡
        //进行右旋转
        if(leftHight()-rightHight()>=2){
            if(left!=null && left.leftHight()<left.rightHight()){
                left.leftRotate();
                rightRotate();//双旋转
            }else {
                rightRotate();//单旋转
            }

        }else if(rightHight()-leftHight()>=2){//进行左旋转
            if(right!=null && right.rightHight()<right.leftHight()){
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }

        }
    }

    private void leftRotate() {
        //创建一个新的节点，值等于当前节点
        Node newLeft = new Node(value);
        //新节点右子树为当前节点右子树
        newLeft.left=left;
        //新节点左子树为当前节点左子树的右子树
        newLeft.right=right.left;

        value = right.value;
        right = right.right;
        left = newLeft;
    }

    private void rightRotate() {
        //创建一个新的节点，值等于当前节点
        Node newRight = new Node(value);
        //新节点右子树为当前节点右子树
        newRight.right=right;
        //新节点左子树为当前节点左子树的右子树
        newRight.left=left.right;

        value = left.value;
        left = left.left;
        right = newRight;
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

    public int hight() {
        return 1+Math.max(this.left==null?0:this.left.hight(),this.right==null?0:this.right.hight());
    }

    public int leftHight() {
        if(left==null){
            return 0;
        }
        return left.hight();
    }

    public int rightHight() {
        if(right==null){
            return 0;
        }
        return right.hight();
    }
}
