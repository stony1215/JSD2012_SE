package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RafDemo2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf=new RandomAccessFile(
                "./text.txt","rw");
        int d=raf.read();
        System.out.println(raf.length());
//        System.out.println(d);
//        d=raf.read();
//        System.out.println(d);
//        d=raf.read();
//        System.out.println(d);
    }
}
