package homework.day03;

import java.io.File;
import java.io.FileFilter;
/**
 * 列出当前目录中所有名字包含s的子项。
 * 
 * 使用匿名内部类和lambda两种写法
 * 
 * 单词记一记:
 * FileFilter   文件过滤器
 * accept       接受
 * 
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		File dir=new File(".");
		if(dir.isDirectory()){
			FileFilter filter=new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					String name=pathname.getName();
					return name.contains("e");
				}
			};
			File[] dirs=dir.listFiles(filter);
			for(int i=0;i<dirs.length;i++) {
				System.out.println(dirs[i].getName());
			}
			FileFilter filter1=fname->fname.getName().contains("e");

			File[] dirs2=dir.listFiles(filter1);
			for(int i=0;i<dirs2.length;i++) {
				System.out.println(dirs2[i].getName());
			}

		}
		
	}
}
