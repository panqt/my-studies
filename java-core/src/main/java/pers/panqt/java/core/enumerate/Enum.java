package pers.panqt.java.core.enumerate;

import lombok.extern.slf4j.Slf4j;

/**  @author panqt 2019/03/25 23:57
 *   
 */
@Slf4j
public class Enum {
    public static void main(String[] args){
        //接口管理 enum
        System.out.println(Food.Coffee.CAPPUCCINO);
    }

    /** switch */
    Color1 color = Color1.GREEN;
    public void change() {
        switch (color) {
            case RED:
                color = Color1.GREEN;
                break;
            case YELLOW:
                color = Color1.RED;
                break;
            case GREEN:
                color = Color1.YELLOW;
                break;
        }
    }
}

enum Color1 {
    GREEN, YELLOW, RED
}

enum Color2 {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    private String name;
    private int index;

    // 构造方法
    private Color2(String name, int index) {
        this.name = name;
        this.index = index;
    }
    public static String getName(int index) {
        for (Color2 c : Color2.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    /** get set 方法 */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;  }


}

interface Food {
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum Dessert implements Food {
        FRUIT, CAKE, GELATO
    }
}