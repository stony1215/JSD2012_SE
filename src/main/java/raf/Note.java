package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 简易记事本工具
 * 程序启动后要求用户输入一个文件名，然后对该文件进行写操作
 * 之后用户在控制台输入的每一行字符串都写入到该文件中
 * 当用户单独输入exit时程序退出
 */
public class Note {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入文件名:");
        Scanner scan=new Scanner(System.in);
        String name=scan.next();
        RandomAccessFile raf=new RandomAccessFile(name+".txt","rw");

        System.out.println("请输入内容,单独输入exit退出:");
        while(true){
            String line=scan.nextLine();
            if("exit".equals(line)) {
                break;
            }
                byte[] data = line.getBytes("utf-8");
                raf.write(data);
                System.out.println("继续或退出(exit)：");

        }
        raf.close();
    }
}
