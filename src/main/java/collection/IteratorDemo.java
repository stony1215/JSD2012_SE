package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合遍历:Iterator迭代器
 * 遍历原则:问,取,.删(其中删除元素不是必须操作);
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        System.out.println(c);
        Iterator<String> it=c.iterator();
//        Iterator it=c.iterator();
        while(it.hasNext()){
            String str=it.next();
            System.out.println(str);
            if("#".equals(str)){
               it.remove();
            }
        }


        System.out.println(c);
    }
}
