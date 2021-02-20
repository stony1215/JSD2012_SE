package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * List定义了一套可以通过下标操作元素的方法,使用更方便
 * ArrayList
 * LinkedList
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        System.out.println(list);
        String str=list.get(0);
//        System.out.println(str);
//        String old=list.set(1,"2");
//        System.out.println(list);

        for (int i=0;i<list.size()/2;i++) {
             str=list.get(i);
             str=list.set(list.size()-1-i,str);
             list.set(i,str);
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
