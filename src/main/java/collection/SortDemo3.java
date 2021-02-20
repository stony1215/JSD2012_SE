package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序字符串
 * 按照Unicode编码排列
 */
public class SortDemo3 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("amily");
        list.add("tom");
        list.add("JACK");
        list.add("Tricy");
        list.add("Pandasa");
        list.add("King");
        list.add("frunk");
        list.add("CoCo");
        list.add("陈sir");
        list.add("苍老师sang");
        list.add("19");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("amily".length());
//        Collections.sort(list, new Comparator<String>() {
//            public int compare(String o1, String o2) {
//                int olen1=o1.length();
//                int olen2=o2.length();
//                return  olen1-olen2;
//
//            }
//        });
        Collections.sort(list,((o1, o2) -> o2.length()-o1.length()));
        System.out.println(list);

    }
}
