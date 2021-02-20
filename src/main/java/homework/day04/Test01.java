package homework.day04;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 改正下面程序的错误
 * 
 * 在解决错误的同时，用注释标注什么原因导致问题的出现
 * 
 * 程序功能需求:使用块读写方式复制指定的文件
 * 
 * 单词记一记:
 * src  是单词source的缩写形式，表示来源
 *      下面使用src表示源文件，就是复制的数据来源的文件
 * 
 * read 读
 * write 写
 * close 关闭
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) throws IOException {
		//少了参数类型 被复制的文件参数类型要改成rw才可读写
//		RandomAccessFile src = new RandomAccessFile("./test.txt", "r");
//		RandomAccessFile desc = new RandomAccessFile("./test_cp.txt", "r");

		RandomAccessFile src = new RandomAccessFile("test.txt","r");
		RandomAccessFile desc = new RandomAccessFile("test_cp.txt","rw");

		int len;
		byte[] data = new byte[1024 * 10];
//循环条件里需要传入参数
//		while ((len = src.read()) != -1) {
		while ((len = src.read(data)) != -1) {
			desc.write(data);
		}
		//写入操作应该放在循环体里面
//		desc.write(data);
//输出到控制台用out
//		System.err.println("复制完毕!");
		System.out.println("复制完毕!");
		src.close();
		desc.close();
	}

}
