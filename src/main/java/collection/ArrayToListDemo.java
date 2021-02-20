package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 数组的工具类:Arrays提供了一个静态方法asList,可以将当前数组转换为一个List集合
 */
public class ArrayToListDemo {
    public static void main(String[] args) {
        String[] arr={"one","two","three","four","five","six"};
        List<String> list= Arrays.asList(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        List<String> list2=new ArrayList<>(list);
        System.out.println(list2);
        list2.add("six");
        System.out.println(list2);

        list.set(1,"2");
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
    }
}
