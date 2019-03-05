package pers.panqt.javase.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *  @time       2019年02月05日	10:42
 *	@author     panqt
 *
 *	@comment    反射
 */
public class Reflection {
    public static void main(String[] args) throws Exception{
        Class c1 = Class.forName("pers.panqt.javase.reflection.Reflection");
        Class c2 = new Reflection().getClass();
        Class c3 = Reflection.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());


        //newInstance()调用的是无参的空构造,如果没有无参构造器，就会抛出异常 java.lang.InstantiationException
        Reflection instance1 = (Reflection)c1.newInstance();
        instance1.sout();


        //只能获取公共构造方法
        Constructor[] constructors1 = c1.getConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println(constructor);
        }
        System.out.println("-------------");

        //获取所有构造方法
        Constructor[] constructors2 = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors2) {
            System.out.println(constructor);
        }

        //构造方法实例化
        Constructor constructor = c1.getConstructor(String.class,int.class);
        Reflection instance2 = (Reflection)constructor.newInstance("String",1);
        instance2.sout();


        //调用方法
        Method method1 = c1.getMethod("sout",int.class);
        Method method2 = c1.getMethod("sout");
        method1.invoke(instance1,1);
        method2.invoke(instance1);


        //获取属性
        Field field = c1.getDeclaredField("s");
        field.setAccessible(true);//可以访问private属性
        field.set(instance1,"略略略");
        instance1.sout();

    }

    //构造方法
    public Reflection(){ }
    private Reflection(int i){this.i=i;}
    protected Reflection(String s){this.s=s;}
    Reflection(float i,String s){this.s=s;}
    public Reflection(String s,int i){this.i=i;this.s=s;}

    private int i;
    private String s;
    public void sout(){
        System.out.println("哈哈哈哈哈哈..........."+i+s);
    }
    public void sout(int i){
        System.out.println("哈哈哈哈哈哈..........."+i+s);
}
}
