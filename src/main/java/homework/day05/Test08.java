package homework.day05;

import java.io.*;

/**
 * 
 * 读取content.txt文件
 * 
 * 进阶:
 * 实现readLine方法，每调用一次就返回content.txt中的一句
 * 
 * 思考:
 * 如果每次都在readLine方法中重新创建输入流，那么总是从头
 * 开始读。只有每次调用readLine看到的输入流都是同一个时，
 * 那么每次调用后开始读取的才是上一次读取后的内容。
 * @author Xiloer
 *
 */
public class Test08 {
	private static BufferedReader br;
	private static FileInputStream fis;
	private static InputStreamReader isr;
	static {
		try {
			fis = new FileInputStream("./content.txt");
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String line = readLine();
		//hello world
		System.out.println(line);
		
		line = readLine();
		//thinking in java
		System.out.println(line);
		
		line = readLine();
		//i love java
		System.out.println(line);
	}
	public static String readLine() {
		try {
			String str=br.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}









/*
 * 在Test08中定义一个静态属性:
 * private static FileInputStream fis = new FileInputStream("./content.txt);
 * 
 * 这样readLine方法中都是用这个fis读取字符，那么就可以做到
 * 每次调用readLine方法都是接着上次读取了。
 * 
 */






