package io;

import java.io.*;

/**
 * 使用流连接形式创建PW完成文本数据的写出操作
 */
public class PWDemo2 {    //向pw2.txt中写入文本数据
    public static void main(String[] args) throws IOException {
        //低级流
        FileOutputStream fos=new FileOutputStream("pw2.txt");
        //转换流,高级流.负责衔接字符字节,负责转换
        OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
        //高级流,缓冲字符输出流,负责块写文本加速
        BufferedWriter bw=new BufferedWriter(osw);
        //高级流,PW.负责按行写字符串,并可以自动行刷新
        PrintWriter pw=new PrintWriter(bw);
        pw.println("因你而改变");
        pw.println("因你而喜忧");
        pw.close();

    }
}
