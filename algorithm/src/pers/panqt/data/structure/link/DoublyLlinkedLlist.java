package pers.panqt.data.structure.link;

/**
 *  @time       2019年01月02日	6:48
 *	@since      V0.1
 *	@author     panqt
 *	@comment    双向循环链表
 */
public class DoublyLlinkedLlist {
    public static void main(String[] args) {
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        DoubleNode n4 = new DoubleNode(4);

        n1.after(n2);
        n2.after(n3);
        n3.after(n4);

        System.out.println(n1.next().getData());
        System.out.println(n2.next().getData());
        System.out.println(n3.next().getData());
        System.out.println(n4.next().getData());
        System.out.println("============");
        System.out.println(n1.pre().getData());
        System.out.println(n2.pre().getData());
        System.out.println(n3.pre().getData());
        System.out.println(n4.pre().getData());
    }
}

class DoubleNode{
    private DoubleNode pre = this;
    private DoubleNode next = this;
    private int data;

    public DoubleNode(int data){
        this.data = data;
    }

    //上一个
    public DoubleNode pre(){
        return pre;
    }
    //下一个
    public DoubleNode next(){
        return next;
    }

    public void after(DoubleNode doubleNode){
        doubleNode.pre = this;
        doubleNode.next = this.next;

        this.next.pre = doubleNode;
        this.next = doubleNode;
    }

    //获得数据
    public int getData(){
        return data;
    }
}
