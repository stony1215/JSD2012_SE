package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile ras=new RandomAccessFile(
                "airplane.png","r");
        RandomAccessFile nras=new RandomAccessFile(
                "newairplane.png","rw");
        int d;
        while((d=ras.read())!=-1){
            nras.write(d);
        }
        ras.close();
        nras.close();

    }
}
