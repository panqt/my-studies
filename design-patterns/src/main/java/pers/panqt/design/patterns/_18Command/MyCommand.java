package pers.panqt.design.patterns._18Command;

/**  @author panqt 2019/03/25 17:21
 *   
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
