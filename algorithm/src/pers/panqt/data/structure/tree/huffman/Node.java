package pers.panqt.data.structure.tree.huffman;

/**
 *  @time       2019年01月07日	5:51
 *	@since      V0.1
 *	@author     panqt
 *	@comment    
 */
public class Node implements Comparable<Node>{
    Byte aByte;
    int value;
    Node left;
    Node right;
    public Node(){
    }
    public Node(int value){
        this.value=value;
    }
    public Node(byte aByte,int value){
        this.value=value;
        this.aByte=aByte;
    }

    public byte getB() {
        return aByte;
    }

    public void setB(byte aByte) {
        this.aByte = aByte;
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
    public int compareTo(Node o) {
        return this.value-o.value;
    }

    @Override
    public String toString() {
        return "aByte=" + aByte +
                ", value=" + value;
    }
}
