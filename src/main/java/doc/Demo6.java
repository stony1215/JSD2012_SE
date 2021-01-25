package doc;

/**
 * 验证补码互补对称公式
 * -n=~n+1;
 */
public class Demo6 {
    public static void main(String[] args) {
        int n=-8;
        int m=~n+1;
        System.out.println(n);
        System.out.println(m);

        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(~n));
        System.out.println(Integer.toBinaryString(~n+1));
        n=Integer.MIN_VALUE;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));


    }
}
