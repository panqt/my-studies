package pers.panqt.data.structure;

/**
 *  @time       2019年01月02日	5:26
 *	@since      V0.1
 *	@author     panqt
 *	@comment    队列
 */
public class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.add(1);
        queue.add(2);


        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.add(3);
        queue.add(4);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private int[] arr = new int[0];

    //入队
    public void add(int element){
        int[] newArr = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            newArr[i] = arr[i];
        }
        newArr[newArr.length-1] = element;
        arr = newArr;
    }

    //出队
    public int poll(){
        int retValue = arr[0];
        int[] newArr = new int[arr.length-1];
        for(int i=0;i<newArr.length;i++){
            newArr[i] = arr[i+1];
        }
        arr = newArr;
        return retValue;
    }
}
