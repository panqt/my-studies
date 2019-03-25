package pers.panqt.design.patterns._18Command;

/**  @author panqt 2019/03/25 17:22
 *   
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
