package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用Raf读写基本类型数据,以及Raf指针的操作
 */
public class RafDemo3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf=new RandomAccessFile("raf.dat","rw");
        int imax=Integer.MAX_VALUE;
        long pos=raf.getFilePointer();
        System.out.println("pos:"+pos);
        raf.write(imax>>>24);
        raf.write(imax>>>16);
        raf.write(imax>>>8);
        raf.write(imax);
        raf.writeInt(imax);
        raf.writeLong(123l);
        raf.writeDouble(123.123);
        System.out.println("写入完毕");
        raf.seek(0);
        //指针回0,读取Int值
        System.out.println(raf.readInt());
        raf.seek(8);
        //读取long值
        System.out.println(raf.readLong());
        //读取double值
        System.out.println(raf.readDouble());
        //修改raf.dat中的long所在位置的值为456
        //1将指针移动到long值的开始位置
        raf.seek(8);
        //2重新写入新的long值来覆盖原有数据
        raf.writeLong(456l);

        raf.seek(8);
        System.out.println(raf.readLong());
        raf.close();
    }
}
