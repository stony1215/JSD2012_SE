package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JDK8之后Collection中添加了一些方法,
 * 其中支持了一个基于lambda表达式遍历集合的方法foreach
 */
public class ForeachDemo {
    public static void main(String[] args) {
        List<String> c=new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        c.add("six");
        //foreach 循环
        for (String s:c) {
            System.out.print(s+",");

        }
        //lambda表达式 foreach
        /*
        Collection的foreach方法要求传入一个lambda表达式,然后将集合每个元素都
        顺序的传给lambda中的s,并执行一次表达式;
        与迭代器相比,由于迭代器是用另一个类Iterator来遍历集合,因此它遍历的过程中不允许
        用集合的方法增删元素(集合有并发安全的实现类,但是仍然不允许多线程操作时使用迭代器遍历与集合方法
        增删同时进行),否则会抛出异常.
        但是集合新添加的foreach方法在遍历的过程中没有上述限制.因为foreach是集合自身方法,
        因此对于并发安全的集合实现类,增删元素和foreach有很好的互斥性,可以保证多线程的并发安全

        我们常用的集合实现类:ArrayList,LinkedList,HashSet都不是并发安全的,因此多线程情况下不应当操作它们.
        集合的工具类:java.util.Collection提供一组静态方法,可以将现有的集合转换为一个并发安全的集合
         */
        //将当前集合转换为一个线程安全的集合
        c=Collections.synchronizedList(c);
        /*
        当多个线程操作同一个集合时,首先应当选取使用线程安全的集合,同时遍历就不应当在使用迭代器,
        而应当使用foreach方法,这样操作做到与增删元素互斥保证并发安全,
         */
        c.forEach(s -> System.out.println(s+","));
        c.forEach(s -> System.out.print(s));
    }
}
