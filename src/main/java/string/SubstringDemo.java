package string;

/**
 * String substring(int start,int end)
 * 截取指定范围内的字符串。两个参数分别时范围对应的下标。
 * 注：在JAVA API中通常使用两个数字表示范围时都是“含头不含尾”的.
 *
 */
public class SubstringDemo {
    public static void main(String[] args) {
        String host="www.tedu.cn";
        String sub=host.substring(4,8);
        System.out.println(sub);
        System.out.println(host.substring(4));
    }
}
