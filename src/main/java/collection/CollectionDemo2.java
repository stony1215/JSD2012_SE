package collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        c.add(new Point(1,8));
        c.add(new Point(1,8));
        c.add(new Point(3,15));
        c.add(new Point(3,15));
        c.add(new Point(20,9));
        c.add(new Point(14,6));
        System.out.println(c);

        Point p1=new Point(1,7);
        Point p2=new Point(1,8);
        /*
        boolean contains(Object o)
        判断当前集合是否包含给定元素,若包含则返回true
         */
        boolean contains=c.contains(p1);
        System.out.println(contains);
        c.remove(p1);
        c.remove(p2);
        System.out.println(c);
    }
}
