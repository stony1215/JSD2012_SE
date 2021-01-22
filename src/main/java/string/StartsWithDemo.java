package string;

/**
 * boolean startsWith(String str)
 * 判断字符串是否是以给定的字符串开始的
 * boolean endsWith(String str)
 * 判断字符串是否是以给定的字符串开始的
 */
public class StartsWithDemo {
    public static void main(String[] args) {
        String str="www.tedu.cn";

       boolean starts=str.startsWith("www");
       boolean ends=str.endsWith("cn");
        System.out.println("starts:"+starts);
        System.out.println("ends:"+ends);
    }
}
