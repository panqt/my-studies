package pers.panqt.jvm.memory;

import java.util.LinkedList;
import java.util.List;

/**
 *  @time       2019年02月05日	17:29
 *	@author     panqt
 *
 *	@comment    java堆 内存溢出
 *              vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *              java对象存放在java堆中，堆满没有空间分配后就会出现内存溢出
 *  @throws     OutOfMemoryError
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<HeapOOM> ooms = new LinkedList<>();

        while (true){
            ooms.add(new HeapOOM());
        }
    }
}
