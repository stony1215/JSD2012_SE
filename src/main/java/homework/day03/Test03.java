package homework.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 将当前目录下的所有文件都复制一份，复制的文件命名为:原
 * 文件名_cp.后缀
 * 比如原文件为:test.dat
 * 复制后的文件为:test_cp.dat
 * 
 * 
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) throws IOException {
		File file=new File("./");
		File[] dirs=file.listFiles();

		for(int i=0;i<dirs.length;i++) {
			String name=dirs[i].getName();
			System.out.println(name);
			if(dirs[i].isFile()) {
				int index=name.lastIndexOf(".");
				StringBuilder builder = new StringBuilder(name);
				String lastName = builder.insert(index, "_cp").toString();
				RandomAccessFile raf = new RandomAccessFile(name, "r");
				RandomAccessFile nraf = new RandomAccessFile(lastName, "rw");
				int len;
				byte[] data=new byte[1024];
				while((len=raf.read(data))!=-1){
					nraf.write(data,0,len);
				}
				raf.close();
				nraf.close();
			}
		}
	}
}




/**
 * 思路:
 * 分为几部分考虑.
 * 第一个是要获取到当前目录中的所有文件(思考哪个API可以解决)
 * 第二个是获取到的每一个文件都要复制(复制用什么API)
 * 第三个是复制的文件名，如何重新组建xxx_cp.xxx的名字?
 *      这里要将原文件名拆开后想办法拼接_cp.
 */

