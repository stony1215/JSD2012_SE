package collection;


import java.util.ArrayList;
import java.util.List;

public class ListDemo3 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for(int i=10;i>0;i--){
            list.add(i);
        }
        System.out.println(list);
        //获取集合当中3-7这部分子集 含头不含围
        List<Integer> sublist=list.subList(3,6);//下标3,下标6
        System.out.println(sublist);

        //将子集中每个元素扩大10倍
        for(int i=0;i<sublist.size();i++){
            sublist.set(i,sublist.get(i)*10);
        }
        System.out.println(sublist);
        System.out.println(list);

        list.subList(2,8).clear();
        System.out.println(list);

    }
}
