package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 通过提高每次读写的数据量减少实际读写的次数可以提高读写效率
 *
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        RAF提供的块读写方法:
        块写:void write(byte[] data)
        一次性将给定的字节数组中所有字节写入文件
        void write(byte[] data,int offset,int len)
        一次性将给定数组中从下标offset开始连续len字节
        块读:
        int read(byte[] data)
        一次性从文件中读取给定的字节数组data总长度的字节量并将
        读取到的字节顺序的存入到该数组中.返回值为实际读取到的字节量.
        如果返回值为-1则表示读取到了文件末尾
         */
        RandomAccessFile ras=new RandomAccessFile("owpk.jpg","r");
        RandomAccessFile nras=new RandomAccessFile("owpkcp.jpg","rw");
        int len;
        long start=System.currentTimeMillis();
        byte[] data=new byte[1024*10];
        while((len=ras.read(data))!=-1){
            nras.write(data,0,len);
        }
        long end=System.currentTimeMillis();
        System.out.println("复制完毕!耗时:"+(end-start)+"ms");
        ras.close();
        nras.close();
    }
}
