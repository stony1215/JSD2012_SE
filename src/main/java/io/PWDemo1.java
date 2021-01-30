package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲字符输出流
 * java.io.BufferedWriter
 * 内部有缓冲区,可以块写入数据
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流,内部总是连接BufferedWrite作为其缓冲功能
 */
public class PWDemo1 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw=new PrintWriter("pw.txt","utf-8");
        pw.println("让我,");
        pw.println("让我");
        System.out.println("over");
        pw.close();
    }


}
