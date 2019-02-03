package pers.panqt.springboot.entry;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 *  @time       2019年02月01日	18:54
 *	@since      V0.1
 *	@author     panqt
 *	@comment    
 */
public class Person {

    @Max(value = 99,message = "太大了")
    @Min(value = 1,message = "太小了")
    private int age;

    @Length(min = 2,max = 5,message = "名字不对")
    @NotBlank
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
