package integer;

/**
 * 包装类常见功能
 */
public class IntegerDemo2 {
    public static void main(String[] args) {
        //获取int最大值最小值
        int imax=Integer.MAX_VALUE;
        System.out.println("imax:"+imax);
        int imin=Integer.MIN_VALUE;
        System.out.println("imin:"+imin);

        long lmax=Long.MAX_VALUE;
        System.out.println("lam:"+lmax);
//        String l=Long.toBinaryString(lmax);
//        System.out.println(Long.toBinaryString(lmax));

        String line="123.123";
        float f=Float.parseFloat(line);
        System.out.println(f);

    }
}
