package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合只能存放引用类型元素,并且存放的是元素的引用(地址)
 */
public class CollectionDemo3 {
    public static void main(String[] args) {
        Point p=new Point(1,2);
        Collection c=new ArrayList();
        c.add(p);
        p.setX(2);
        System.out.println(c);
        System.out.println(p);
    }
}
