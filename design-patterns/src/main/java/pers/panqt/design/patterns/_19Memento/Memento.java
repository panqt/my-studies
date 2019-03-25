package pers.panqt.design.patterns._19Memento;

/**  @author panqt 2019/03/25 17:27
 *   
 */
/**@Slf4j*/
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
