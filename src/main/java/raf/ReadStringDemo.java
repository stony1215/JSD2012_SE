package raf;
/**
 * 读取文本内容
 */

import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf=new RandomAccessFile("raf.txt","r");
        byte[] data=new byte[(int)raf.length()];
        raf.read(data);
        String line=new String(data,"utf-8");
        System.out.println(line);
        raf.close();
    }
}
