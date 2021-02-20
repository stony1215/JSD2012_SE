package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * java标准IO,可以用相同的读写方式读写不同的设备
 * java将IO比喻为"流".可以理解为是连接程序与设备之间的管道,管道里面是按照同一个方向
 * 流动的字节
 * java将流的方向划分为两个操作:
 * 输入:用来读取,是从设备到程序的方向,是获取数据使用的
 * 输出:用来写出,是从程序到设备的方向,是发送数据使用的
 * java.io.InputStream是所有字节输入流的超累,里面定义了读取字节的方法
 * java.io.OutputStream是所有字节输出流的超累,里面定义了写出字节的方法
 * java将流分为两类:节点流和处理流
 * 节点流:也称为低级流,是实际连接程序与设备的管道,负责实际读取字节的流
 *      读写一定是建立在节点流的基础上进行的.操作不同设备有对应的低级流,例如读写文件有文件流
 * 处理流:也称高级流,不能独立存在,必须连接在其他流上,目的是当数据"流经"当前流时对其做某些加工处理
 *      简化我们的操作
 *  实际开发中我们总是回串联一组高级流最终连接到低级流上,在数据进行读写的过程中对数据做流水线式的
 *  加工处理,这也就成为流连接,也是IO的精髓
 *
 *  文件流
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        /*
        文件输出流构造方法:
        FileOutputStream(String path)
        FileOutputStream(File file)
        以上两种构造器创建的文件流为覆盖写入模式

        文件流重载的构造方法
        FileOutputStream(String path,boolean append)
        FileOutputStream(File file,boolean append)

         */
        FileOutputStream fos=new FileOutputStream("fos.txt",true);
//        String line="退一步,海阔天空.";
//        byte[] data=line.getBytes("utf-8");
        fos.write("大鹏展翅,,".getBytes());

//        line="忍一时越想越气";
        fos.write("鹏鸟高飞".getBytes("utf-8"));
        System.out.println("写出完毕!");
        fos.close();
    }
}
