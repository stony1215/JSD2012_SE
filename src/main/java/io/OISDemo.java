package io;

import java.io.*;

/**
 * 对象输入流
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //读取person.obj文件中的person对象
        FileInputStream fis=new FileInputStream("person.obj");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Person p=(Person)ois.readObject();
        System.out.println(p);
        ois.close();
    }
}
