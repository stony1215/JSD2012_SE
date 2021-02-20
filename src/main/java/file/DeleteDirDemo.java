package file;

import java.io.File;

public class DeleteDirDemo {
    public static void main(String[] args) {
        File file=new File("demo");
        if(file.exists()){
            file.delete();

            System.out.println("已删除");
        }else{
            System.out.println("失败不存在");
        }
    }
}
