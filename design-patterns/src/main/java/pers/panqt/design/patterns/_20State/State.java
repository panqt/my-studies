package pers.panqt.design.patterns._20State;

/**  @author panqt 2019/03/25 17:34
 *   
 */
/**@Slf4j*/
public class State {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1(){
        System.out.println("execute the first opt!");
    }

    public void method2(){
        System.out.println("execute the second opt!");
    }
}
