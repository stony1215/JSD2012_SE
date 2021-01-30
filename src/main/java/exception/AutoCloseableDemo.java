package exception;

import java.io.*;

public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (
                FileOutputStream fos
                        = new FileOutputStream("fos.dat");

        ) {
            String str = "abcd";
            fos.write(5);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            PrintWriter pw=new PrintWriter(
//                    new BufferedWriter(
//                            new OutputStreamWriter(
//                                    new FileOutputStream("fos.dat")
//                            )
//                    )
//            );
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}
