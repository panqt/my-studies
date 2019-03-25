package pers.panqt.java.core.lambda;

import lombok.extern.slf4j.Slf4j;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**  @author panqt 2019/03/25 21:51
 *   @see <a>https://www.cnblogs.com/snowInPluto/p/5981400.html</a>
 *   JAVA 8 函数式编程
 */
@Slf4j
public class Lambda {
    public static void main(String[] args){

        /*不包含参数,使用空括号 () 表示没有参数。该 Lambda 表达式 实现了 Runnable 接口,
         *该接口也只有一个 run 方法,没有参数,且返回类型为 void。*/
        Runnable noArguments = () -> System.out.println("Hello World");


        /* 包含且只包含一个参数,可省略参数的括号 参数 event 传给了 e */
        ActionListener oneArgument = event -> System.out.println("button clicked");


        /*多行可以用大括号，一行也可以*/
        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };

        /* 包含多个参数，这行代码并不是将两个数字相加,而是创建了一个函数,变量 add 是两个数相加的代码，而不是和 */
        BinaryOperator<Long> add = (x, y) -> x + y;


        /* 显式声明参数类型 */
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;




        //JDK 8 中提供了一组常用的核心函数接口：

        //用于判别一个对象
        Predicate predicate = t -> {return true;};

        //用于接收一个对象进行处理但没有返回
        Consumer consumer = t ->{};

        //转换一个对象为不同类型的对象
        Function function = r ->{return new Date();};

        //提供一个对象
        Supplier supplier = () -> {return new Date();};

        //接收对象并返回同类型的对象
        UnaryOperator unaryOperator = t ->(t);

        //接收两个同类型的对象，并返回一个原类型对象
        BinaryOperator binaryOperator = (kx,ky) -> {return kx;};




        //Stream : 遍历 Collection 方便
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(22));
        persons.add(new Person(21));
        persons.add(new Person(18));

        long count = persons.stream().filter(person -> person.getAge() > 20).count();
        System.out.println(count);

        //collect(toList()) 方法由 Stream 里的值生成一个列表
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        System.out.println(collected);

        // map 一个流中的值转换成一个新的流。
        List<String> collected2 = Stream.of("a", "b", "hello").map(string -> string.toUpperCase()).collect(Collectors.toList());
        System.out.println(collected2);

        //filter 方法就是接受的一个 Predicate 的匿名函数类，判断对象是否符合条件，符合条件的才保留下来。
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1").filter(value -> Character.isDigit(value.charAt(0))).collect(Collectors.toList());
        System.out.println(beginningWithNumbers);

        //flatMap 方法可用 Stream 替换值，然后将多个 Stream 连接成一个 Stream。
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        System.out.println(together);

        //max和min Stream 上常用的操作之一是求最大值和最小值。Stream API 中的 max 和 min 操作足以解决这一问题。
        List<Integer> list = Stream.of(3, 5, 2, 9, 1).collect(Collectors.toList());
        int maxInt = list.stream()
                .max(Integer::compareTo)
                .get();
        int minInt = list.stream()
                .min(Integer::compareTo)
                .get();
        System.out.println(maxInt);
        System.out.println(minInt);


        //reduce 操作可以实现从一组值中生成一个值。在上述例子中用到的 count、min 和 max 方法,因为常用而被纳入标准库中。事实上，这些方法都是 reduce 操作。
        //0 + 1 + 2 + 3 + 4 = 10
        int result = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println(result);

        int result2 = Stream.of(1, 2, 3, 4)
                .reduce(1, (acc, element) -> acc * element);



        // parallel() 并行化操作只有在 数据规模比较大 或者 数据的处理时间比较长 的时候才能体现出有事，所以并不是每个地方都需要让数据并行化，应该具体问题具体分析。
        int sumSize = Stream.of("Apple", "Banana", "Orange", "Pear")
                .parallel()
                .map(s -> s.length())
                .reduce(Integer::sum)
                .get();
        System.out.println(sumSize);

        //如果我们需要对流中的数据进行排序，可以调用 sorted 方法：
        List<Integer> sortedList = list.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }
}

class Person{
    int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}