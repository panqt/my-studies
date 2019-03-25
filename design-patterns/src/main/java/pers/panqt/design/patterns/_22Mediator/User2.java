package pers.panqt.design.patterns._22Mediator;

/**  @author panqt 2019/03/25 17:43
 *   
 */
public class User2 extends User {

    public User2(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}
