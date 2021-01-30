package io;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * 简易记事本功能
 * 程序启动后要求用户输入文件名,然后对文件进行写操作
 * 之后用户输入的每一行字符串都要按行写入到文件中
 * 当用户单独输入exit时程序退出
 * 要求:创建PrintWrite并且自行创建流连接完成
 */
public class Note {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner s=new Scanner(System.in);
        System.out.println("请输入文件名:");
        String filename=s.nextLine();
        FileOutputStream fos=new FileOutputStream(filename+".txt",true);
        OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
        BufferedWriter bw=new BufferedWriter(osw);
        PrintWriter pw=new PrintWriter(bw,true);
        while(true) {
            System.out.println("请输入文件内容,退出请按exit");

            String str=s.nextLine();
            if("exit".equals(str)){
                break;
            }
            pw.println(str);
        }
        pw.close();

    }
}
