package io;

import java.io.*;

/**
 * 套路流
 */
public class Taowa {
    //打印输出流
    PrintWriter pw;

    {
        try {
            pw = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream("./content.txt")
                                )
                        )
                );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //输入流
    BufferedReader br;

    {
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("./content.txt")
                    )
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
