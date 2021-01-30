package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("fos.txt");
        byte[] data=new byte[1000];
        int len=fis.read(data);
        System.out.println("实际读取了"+len+"个字节");
        String line=new String(data,0,len,"utf-8");
        System.out.println(line);
        System.out.println(line.length());
        fis.close();
    }
}
