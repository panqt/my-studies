package pers.panqt.data.structure;

/**
 *  @time       2019年01月02日	5:42
 *	@since      V0.1
 *	@author     panqt
 *	@comment    单链表
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.append(n2).append(n3);

        n1.show();

        System.out.println("================");
        n1.after(new Node(4));
        n1.show();
    }
}


class Node{

    private int data;
    private Node next = null;

    public Node(int data){
        this.data = data;
    }

    //末尾追加
    public Node append(Node node){
        Node currentNode = this;

        while (true){
            if(currentNode.next() != null){
                currentNode = currentNode.next();
            }else {
                break;
            }
        }
        currentNode.next = node;
        return this;
    }

    //删除下一个节点
    public void removeNext(){
        if(this.next != null)
            this.next = this.next.next;
    }

    //后面插入节点
    public void after(Node node){
        node.next = this.next;
        this.next = node;
    }

    //获取下一个节点
    public Node next(){
        return next;
    }

    //获得数据
    public int getData(){
        return data;
    }

    //显示数据
    public void show(){
        Node currentNode = this;
        do{
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }while (currentNode != null);
    }
}