package pers.panqt.design.patterns._16Iterator;

/**  @author panqt 2019/03/25 17:08
 *   
 */
public interface Iterator {
    //前移
    public Object previous();

    //后移
    public Object next();
    public boolean hasNext();

    //取得第一个元素
    public Object first();
}