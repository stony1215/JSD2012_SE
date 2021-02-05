package homework.day11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * 生成10个0-100之间的不重复的随机数,并输出
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Random rand=new Random();
		ArrayList<Integer> list=new ArrayList<>();
		Integer a=rand.nextInt(101);
		list.add(a);

		for (int i =0; i<9; ) {
			a = rand.nextInt(101);
			if (a != list.get(i)) {
				list.add(a);
				i++;
			}

		}

		System.out.println(list);
	}
}
