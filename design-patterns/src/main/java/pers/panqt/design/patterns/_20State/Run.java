package pers.panqt.design.patterns._20State;

/**  @author panqt 2019/03/25 17:34
 *   
 */
/**@Slf4j*/
public class Run {
    public static void main(String[] args) {

        State state = new State();
        Context context = new Context(state);

        //设置第一种状态
        state.setValue("state1");
        context.method();

        //设置第二种状态
        state.setValue("state2");
        context.method();
    }
}
