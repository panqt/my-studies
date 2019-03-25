package pers.panqt.design.patterns._19Memento;

/**  @author panqt 2019/03/25 17:27
 *   
 */
/**@Slf4j*/
public class Storage {

    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
