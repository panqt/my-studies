package pers.panqt.design.patterns._10Bridge;

/**  @author panqt 2019/03/25 16:30
 *   
 */
public abstract class Bridge {
    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
