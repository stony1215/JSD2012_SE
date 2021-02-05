package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 集合的工具类Collections提供了一个静态方法sort,可以对List集合进行自然排序
 * 从小到大排序
 */
public class SortListDemo {
    public static void main(String[] args) {
        List<Integer> li=new ArrayList<>();
        Random rand=new Random();
        for(int i=0;i<10;i++){
            li.add(rand.nextInt(100));
        }
        System.out.println(li);
        Collections.sort(li);
        System.out.println(li);

        Collections.shuffle(li);
        System.out.println(li);

        Collections.sort(li,(i1,i2)->i2-i1);
        System.out.println(li);
    }
}
