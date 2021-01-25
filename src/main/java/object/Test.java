package object;

/**
 * 测试Object中常用的方法
 */
public class Test {
    public static void main(String[] args) {
        Poiont p=new Poiont(1,2);
        p.toString();
        /*
        向控制台输出是很常用的操作，当我们输出一个对象时，
        实际上该方法会调用该对象的toString方法，将返回的字符串输出到控制台
         */
        System.out.println(p);
        /*
        字符串与其他类型连接时，会将其他类型转换成String
        而转换也是依靠该对象的toString

         */
        String line="这个对象是："+p;
        System.out.println(line);
        Poiont p2=new Poiont(1,2);
        /*
        Object 提供的另一个常用方法：
        boolean equals(Object o)
        该方法的作用时比较当前对象与参数给定的对象内容是否相同
        但是如果子类不重写这个方法，则该方法毫无价值
        因为Object实现该方法时使用的时”==“比较的。
         */
        System.out.println(p==p2);
        System.out.println(p.equals(p2));
        /*
        Java提供的类基本都妥善的重写了toString和equals
        比如String
        只有我们自己定义的类在使用时需要去重写
         */
    }
}
