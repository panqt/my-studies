package pers.panqt.data.structure.link;

/**
 *  @time       2019年01月02日	6:28
 *	@since      V0.1
 *	@author     panqt
 *	@comment    循环链表
 */
public class CircularLinkedList {
    public static void main(String[] args) {
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        LoopNode n4 = new LoopNode(4);

        n1.after(n2);
        n2.after(n3);
        n3.after(n4);

        System.out.println(n1.next().getData());
        System.out.println(n2.next().getData());
        System.out.println(n3.next().getData());
        System.out.println(n4.next().getData());
    }
}
class LoopNode{

    private int data;
    private LoopNode next = this;  //关键

    public LoopNode(int data){
        this.data = data;
    }

    //删除下一个节点
    public void removeNext(){
        if(this.next != null)
            this.next = this.next.next;
    }

    //后面插入节点
    public void after(LoopNode node){
        node.next = this.next;
        this.next = node;
    }

    //获取下一个节点
    public LoopNode next(){
        return next;
    }

    //获得数据
    public int getData(){
        return data;
    }


}