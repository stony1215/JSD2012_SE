package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成文件复制
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        /*
        创建文件输入流读取源文件
        创建文件输出流写入复制文件
        循环快读写完成复制
        关闭两个流
         */
        FileInputStream fis=new FileInputStream("fos.txt");
        FileOutputStream nfis=new FileOutputStream("fos_cp.txt");
        int len;
        byte[] data=new byte[1024*10];
        while((len=fis.read(data))!=-1){
            nfis.write(data);
        }
        System.out.println("复制完毕!");
        fis.close();
        nfis.close();

    }
}
