package pers.panqt.design.patterns._03Singleton;

/**  @author panqt 2019/03/25 15:50
 *   
 */
public class Singleton {

    /** 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
     *  volatile 保证线程可见性
     * */
    private volatile static Singleton instance = null;

    /** 私有构造方法，防止被实例化 */
    private Singleton() {
    }

    /** 静态工程方法，创建实例 加锁保证线程安全*/
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /** 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return instance;
    }
}

