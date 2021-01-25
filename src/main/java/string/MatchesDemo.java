package string;

/**
 * 正则表达式
 * boolean matcher(String regex)
 * 使用给定的正则表达式验证当前字符串是否符合格式要求，
 * 符合则返回true
 */
public class MatchesDemo {
    public static void main(String[] args) {
        String email="513500561_1aa@qq.com";
        /*
        邮箱的正则：[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+
         */
        String regex="[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        boolean match=email.matches(regex);
        if(match){
            System.out.println("是邮箱");
        }else{
            System.out.println("不是邮箱");
        }
    }

}
