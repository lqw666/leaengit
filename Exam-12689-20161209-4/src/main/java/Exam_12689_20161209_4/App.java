package Exam_12689_20161209_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < 50; i++) {
			list.add((int) (Math.random() * 100));
		}

		for (Integer integer : list) {
			int x = integer.intValue() / 10;
			if (map.containsKey(x)) {
				map.get(x).add(integer);
			} else {
				ArrayList<Integer> set = new ArrayList<Integer>();
				set.add(integer);
				map.put(x, set);
			}
		}
		System.out.print("随机生成50个小于100的数，分别为：");
		for (Integer integer : list) {
			if (list.indexOf(integer) == (list.size() - 1)) {
				System.out.print(integer + "\n");
			} else {
				System.out.print(integer + ",");
			}
		}
		System.out.println("Map中的数据为：" + map);
		Set<Integer> set = map.keySet();
		Map<Integer, TreeSet<Integer>> map2 = new HashMap<Integer, TreeSet<Integer>>();
		for (Integer integer : set) {
			TreeSet<Integer> set2 = new TreeSet<Integer>();
			Iterator<Integer> iterator = map.get(integer).iterator();
			while (iterator.hasNext()) {
				set2.add(iterator.next());
			}
			map2.put(integer, set2);
		}
		System.out.println("排序后的Map为：" + map2);
	}
}
