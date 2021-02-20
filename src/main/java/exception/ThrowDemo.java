package exception;

import io.Person;

/**
 * 异常的抛出
 * throw关键字可以主动抛一个异常.通常下列情况会主动抛出异常
 * 1:当程序出现了一个异常,但是该异常不应当在当前代码片段被解决时可以排除给调用者解决
 * 2:程序遇到一个满足语法但是不满足业务逻辑的情况时,可以主动创建一个对应的异常抛出
 *
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person p=new Person();
        try {
            p.setAge(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("年龄:"+p.getAge());
    }
}
