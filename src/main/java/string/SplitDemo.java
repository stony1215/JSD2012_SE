package string;

/**
 * String 支持正则表达式方法二：
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式的部分进行拆分，
 * 将拆分后的所有部分以一个String数组形式返回。
 */
public class SplitDemo {
    public static void main(String[] args) {
        String str="abcd1234efgh5678ijkl9101112mnop";
        //按照数字部分拆分
        String[] arr=str.split("[a-z]+");

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        //按符号拆分
        String str1="123.456.7,89";
        String[] arr1=str1.split("\\.");
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }

    }
}
