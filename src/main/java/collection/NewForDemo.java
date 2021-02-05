package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强型for循环,也称为新循环
 * 新循环不取代传统for循环的工作,它只是用来让我们相同的语法遍历集合和数组使用
 */
public class NewForDemo {
    public static void main(String[] args) {
        String[] arr={"one","two","three","four","five"};
        for(String s:arr){
            System.out.println(s);
        }
        Collection<String> c=new ArrayList<>();
        c.add("six");
        c.add("seven");
        c.add("eight");
        c.add("nine");
        c.add("ten");
        for (String s:c
             ) {
            System.out.println(s);
        }
    }
}
