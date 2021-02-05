package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionDemo4 {
    public static void main(String[] args) {
        Collection c1=new ArrayList();
        c1.add("C++");
        c1.add("java");
        c1.add(".net");
//        System.out.println(c1);
        Collection c2=new HashSet();
        c2.add("android");
        c2.add("java");
        c2.add("ios");
//        System.out.println(c2);
        /*
        boolean addAll(Collection c)
        发生变化返回true
         */
        boolean b1=c1.addAll(c2);
        System.out.println(b1+""+c1);
        boolean b2=c2.addAll(c1);
        System.out.println(b2+""+c2);

        /*
        c1.add(c2)添加c2集合到c1 而非元素
        */
        ArrayList c3=new ArrayList();
        c3.add("android");
        c3.add("C++");
//        c3.add("php");
        System.out.println(c1.contains(c3));
        System.out.println(c1.containsAll(c3));
        System.out.println(c3.get(1));
        c1.removeAll(c3);
        System.out.println(c1);
        System.out.println(c3);


    }
}
