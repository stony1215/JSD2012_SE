package lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * JDK8之后推出了一个新的特性:lambda表达式
 * lambda表达式可以用更简短的语法创建匿名内部类
 * 语法:(参数列表)->{
 *     方法体
 * }
 * 需要注意,使用lambda表达式创建时实现的接口中只能有一个抽象方法
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
//        FileFilter filter=new FileFilter() {
//            @Override
//            public boolean accept(File file) {
//                return file.getName().contains("e");
//            }
//        };
        File dir=new File(".");
//        FileFilter filter1=(f)->{
//            return f.getName().contains("e");
//        };
        FileFilter filter1=file->file.getName().contains("e");
        File[] subs=dir.listFiles(filter1);

        for(int i=0;i<subs.length;i++){
            System.out.println(subs[i].getName());
        }

    }
}
