package file;

import java.io.File;

public class MKDirsDemo {
    public static void main(String[] args) {
        File dirs=new File("a/b/c/d/e/f");
        if (dirs.exists()){
            System.out.println("已存在");
        }else{
            dirs.mkdirs();
            System.out.println("成功");
        }
    }
}
