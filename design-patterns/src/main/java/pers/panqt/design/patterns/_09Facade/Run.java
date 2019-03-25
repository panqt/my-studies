package pers.panqt.design.patterns._09Facade;

/**  @author panqt 2019/03/25 16:29
 *   
 */
public class Run {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
