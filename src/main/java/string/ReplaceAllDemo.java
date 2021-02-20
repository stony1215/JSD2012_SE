package string;

/**
 * String 支持正则表达式的方法3：
 * String replaceAll(String
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {
        String str="abcd1234efgh5678ijkl9101112mnop";
        //将字符串中的数字部分替换为"#NUMBER#"
        //str=str.replaceAll("[0-9]+","#NUMBER#");
        str=str.replaceAll("[a-z]+","");
        //str=str.replaceAll("[a-z]+","#NUMBER#");
        System.out.println(str);
        //和谐用语
        String regex="(wrrt|frewf}fdfds|fk|djb)";
        String message="fk!dfrd!enijiushigedjb";
        message=message.replaceAll(regex,"***");
        System.out.println(message);

    }
}
