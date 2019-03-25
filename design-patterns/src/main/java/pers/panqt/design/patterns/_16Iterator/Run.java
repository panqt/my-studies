package pers.panqt.design.patterns._16Iterator;

/**  @author panqt 2019/03/25 17:08
 *   
 */
/**@Slf4j*/
public class Run {
    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
