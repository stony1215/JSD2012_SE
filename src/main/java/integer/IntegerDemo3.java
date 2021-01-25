package integer;

/**
 * JDK5推出时推出一个特性：自动拆装箱
 * 该特性是编译期认可的，当我们在基本类型与引用类型赋值时，
 * 编译器会自动触发拆装箱
 */
public class IntegerDemo3 {
    public static void main(String[] args) {
        int d=123;

        Integer i=d;
        d=i;
    }
}
