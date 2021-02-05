package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK8之后Collection中添加了一些方法,其中支持了一个基于lambda表达式遍历集合的方法foreach
 */
public class ForeachDemo {
    public static void main(String[] args) {
        Collection<String> c=new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        c.add("six");

        for (String s:c
             ) {
            System.out.print(s+",");
        }
    }
}
