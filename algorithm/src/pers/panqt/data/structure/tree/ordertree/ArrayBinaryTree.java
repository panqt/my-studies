package pers.panqt.data.structure.tree.ordertree;

/**
 *  @time       2019年01月05日	19:27
 *	@since      V0.1
 *	@author     panqt
 *	@comment    
 */
public class ArrayBinaryTree {

    int[]  data;
    public ArrayBinaryTree(int[]  data){
        this.data=data;
    }

    public void frontShow(){
        frontShow(0);
    }

    public void frontShow(int index){
        if (data==null || data.length==0){
            return;
        }

        System.out.print(data[index]);
        if (index*2+1<data.length)
            frontShow(data[index*2+1]);
        if (index*2+2<data.length)
            frontShow(data[index*2+2]);
    }
}
