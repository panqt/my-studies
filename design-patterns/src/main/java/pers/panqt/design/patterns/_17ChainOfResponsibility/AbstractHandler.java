package pers.panqt.design.patterns._17ChainOfResponsibility;

/**  @author panqt 2019/03/25 17:14
 *   
 */
public abstract class AbstractHandler {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
