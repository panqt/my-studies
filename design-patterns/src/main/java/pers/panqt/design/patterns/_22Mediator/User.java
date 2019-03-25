package pers.panqt.design.patterns._22Mediator;

/**  @author panqt 2019/03/25 17:43
 *   
 */
public abstract class User {

    private Mediator mediator;

    public Mediator getMediator(){
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}