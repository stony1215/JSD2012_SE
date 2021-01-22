package string;

/**
 * int indexOf(String str)
 * 返回给定字符串在当前字符串的位置，如果当前字符串不包含给定内容则返回值为-1
 */
public class IndexOfDemo {
    public static void main(String[] args) {
        String str="thinking in java";
        //          0123456789012345
        int index=str.indexOf("in");//检索str中第一次出现in的位置
        System.out.println(index);//2

        //重载的indexOf方法可以从指定位置开始检索第一次出现指定字符串的位置
        index=str.indexOf("in",2);
        //从下标2处开始寻找第一次出现in的位置
        System.out.println(index);//2


        System.out.println(str.lastIndexOf("in"));
    }
}
