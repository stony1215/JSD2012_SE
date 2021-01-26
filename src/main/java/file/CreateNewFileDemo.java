package file;

import java.io.File;
import java.io.IOException;

public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        File file=new File("./text.txt");
        if(file.exists()){
            System.out.println("该文件已经存在!");
        }else {
            file.createNewFile();
            System.out.println("文件创建成功");
        }

    }
}
