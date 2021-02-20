package homework;

interface IFace {
}

class CFace implements IFace {
}

class Base {
}

public class ObRef extends Base {
    public static void main(String argv[]) {
        Object obj = new Object() {
            public int hashCode() {
                return 42;
            }
        };
        System.out.println(obj.hashCode());
    }
}
