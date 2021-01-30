package io;

import com.sun.scenario.animation.shared.ClipEnvelope;

import java.io.*;

/**
 * 使用缓冲流完成文件复制
 * java.io.BufferedInputStream和BufferedOutputStream
 * 它们是一对高级流,在流连接中的作用是提高读写效率.
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("ideasetup.exe");
        BufferedInputStream bis=new BufferedInputStream(fis,1024*10);
        FileOutputStream fos=new FileOutputStream("idea_cp.exe");
        BufferedOutputStream bos=new BufferedOutputStream(fos,1024*10);
        int d;
        byte[] data=new byte[1024*10];
        long start=System.currentTimeMillis();
        while((d=bis.read(data))!=-1){
            bos.write(data,0,d);
        }
        long end=System.currentTimeMillis();
        System.out.println("复制完毕,耗时:"+(end-start)+"ms");
        bis.close();
        bos.close();
    }
}
