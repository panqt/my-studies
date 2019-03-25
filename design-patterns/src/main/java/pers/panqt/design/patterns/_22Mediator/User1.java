package pers.panqt.design.patterns._22Mediator;

/**  @author panqt 2019/03/25 17:43
 *   
 */
public class User1 extends User {

    public User1(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exe!");
    }
}