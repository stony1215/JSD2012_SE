package file;

import java.io.File;

public class MKDirDemo {
    public static void main(String[] args) {
        File dir=new File("demo");
        if(dir.exists()){
            System.out.println("该目录已存在");
        }else{
            dir.mkdir();
            System.out.println("目录创建成功");
        }
    }
}
