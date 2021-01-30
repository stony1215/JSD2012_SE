package homework.day05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 将当前目录下的所有obj文件获取到，并进行
 * 反序列化后输出每个用户的信息(直接输出反序
 * 列化后的User对象即可)
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file=new File("./");
        File[] dirs=file.listFiles();
        for(int i=0;i<dirs.length;i++){
            String filename=dirs[i].getName();
            if(filename.contains(".obj")){
                FileInputStream fis=new FileInputStream(filename);
                ObjectInputStream ois=new ObjectInputStream(fis);
                Object f=ois.readObject();
                System.out.println(f);

            }
        }

    }

}
