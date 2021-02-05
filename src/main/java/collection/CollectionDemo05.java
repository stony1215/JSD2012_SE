package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * JDK5之后推出了一个特性:泛型
 * public interface Collection<E>...
 * E:表示并限定一种类型
 */
public class CollectionDemo05 {
    public static void main(String[] args) {
        Collection<String> c=new ArrayList<String>();
        c.add("one");
        c.add("two");
        c.add("three");
//        c.add(new Point(1,2));//不匹配
        Iterator<String> it=c.iterator();
    }
}
