package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JAVA集合框架
 * java.util.Collection接口,是所有集合的顶级接口,里面定义了集合都应具备的功能.
 * 集合与数组一样,可以保存一组元素,并且对于元素的操作都以方法的形式提供出来,使用方便.
 * 并且集合有多种不同的数据结构可供选择.
 *
 * Collection下面有两个常见的子接口:
 * java.util.List:线性表,这类集合的特点是可以存放重复元素,并且有序.
 *      常用实现类:java.util.ArrayList,  java.util.LinkedList
 * java.util.Set:这类集合的特点是不能存放重复元素.
 *      常用实现类:java.util.HashSet
 * 重复元素的判定标准为元素自身equals方法比较的结果.为true则认为是重要元素.
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        c.add(null);
        System.out.println(c+"---数量:"+c.size());
        c.remove("one");
        System.out.println(c+"---数量:"+c.size());

    }
}
