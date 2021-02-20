package doc;

/**
 * 补码编码的规律
 * 1.最大值：0+n个1
 * -int；类型最大值0+31个1
 * -long类型最大值0+63个1
 * 2.最小值：1+n个0
 * -int类型最小值1+31个0
 * -long类型最小值1+63个0
 */
public class Demo04 {
    public static void main(String[] args) {
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        long lmax=Long.MAX_VALUE;
        long lmin=Long.MIN_VALUE;

        System.out.println(Integer.toBinaryString(max));
        System.out.println(Integer.toBinaryString(min));
        System.out.println(Long.toBinaryString(lmax));
        System.out.println(Long.toBinaryString(lmax));
        int m=1;
        int n=-1;
        long l=-1L;
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Long.toBinaryString(l));
    }
}
