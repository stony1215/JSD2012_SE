package doc;

/**     b  6
 *   n=10110110 10011001 00111101 01111110
 *     a1
 *     10110110 00000000 00000000 00000000
 *     a2
 *     00000000 10011001 00000000 00000000
 *     a3
 *     00000000 00000000 00111101 00000000
 *    a4
 *     00000000 00000000 00000000 01111110
 *  m=n<<8
 *
 */
public class Demo08 {
    public static void main(String[] args) {
        int b1=0b10110110;
        int b2=0b10011001;
        int b3=0b00111101;
        int b4=0b01111110;

        int a1=b1<<24;
        int a2=b2<<16;
        int a3=b3<<8;
        int a4=b4&0xff;

        int m=a1|a2|a3|a4;
        System.out.println(Integer.toBinaryString(m));
    }
}
