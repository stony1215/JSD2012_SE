package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合提供了一对重载的add,remove方法
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("six");
        list.add("seven");
        System.out.println(list);
        list.add(4,"five");
        System.out.println(list);
        String old=list.remove(4);
        System.out.println(old);
        System.out.println(list);

    }
}
