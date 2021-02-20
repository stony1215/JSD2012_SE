package doc;

public class Demo07 {
    public static void main(String[] args) {
        int n=0x6e188fd5;
        int m=0xff;
        int k=n&m;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(k));
    }
}
