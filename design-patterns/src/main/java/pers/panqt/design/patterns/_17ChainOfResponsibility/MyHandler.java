package pers.panqt.design.patterns._17ChainOfResponsibility;

/**  @author panqt 2019/03/25 17:15
 *   
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name+"deal!");
        if(getHandler()!=null){
            getHandler().operator();
        }
    }
}