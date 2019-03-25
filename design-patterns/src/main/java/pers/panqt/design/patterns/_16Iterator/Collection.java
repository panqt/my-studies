package pers.panqt.design.patterns._16Iterator;

/**  @author panqt 2019/03/25 17:08
 *   
 */
public interface Collection {

    public Iterator iterator();

    /*取得集合元素*/
    public Object get(int i);

    /*取得集合大小*/
    public int size();
}
