package raf;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 向文件中写入文本数据
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf=new RandomAccessFile(
                "raf.txt","rw");
        /*
        GBK:国标编码，其中英文是1字节，所有中文2字节
        UTF-8：万国码，其中英文1字节，中文3字节
         */

        /*
        String提供的方法：
        将当前字符串内容按照指定的字符集转换为一组字节
         */
        String str="在我的旁边是你曾经最好的闺蜜,";
       byte[]  data=str.getBytes("utf-8");
       raf.write(data);
       str="可当我站起身来在房间里寻找你";
       data=str.getBytes("utf-8");
       raf.write(data);
        System.out.println("写出完毕！");
        raf.close();

    }
}
