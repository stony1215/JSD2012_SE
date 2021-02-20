package exception;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 异常处理机制中的try-catch
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
//        String str=null;
        String str="abc";
        try{
            System.out.println(str.charAt(0));
            System.out.println(str.length());
            System.out.println(Integer.parseInt(str));
        }catch(NullPointerException e){
            System.out.println("空指针异常");
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("下标越界");
        }catch(Exception e){
            System.out.println("转换异常");
        }
        /*
        catch超类异常的意义:
        当try中某几类异常希望使用相同处理办法时,可以catch这些
        异常的超类
        在最后一个catch处捕获Exception也可以避免因为一个未处理的
        异常导致程序中断
        当多个catch的异常之间存在继承关系时,子类型异常要在上面先行捕获,
        超类异常在下,否则编译不通过.
         */
        System.out.println("程序结束了!");
    }
}
