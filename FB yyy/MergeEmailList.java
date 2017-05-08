package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
Given 1 million email list:
list 1: a@a.com, b@b.com
list 2: b@b.com, c@c.com
list 3: e@e.com
list 4: a@a.com

Combine lists with identical emails, and output tuples:
(list 1, list 2, list 4) (a@a.com, b@b.com, c@c.com)
(list 3) (e@e.com)
 *
 */

public class MergeEmailList {
	public static List<List<String>> mergeEmailList(List<List<String>> list) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < list.size(); ++i) {
			List<String> emails = list.get(i);
			String first = emails.get(0);
			if (!map.containsKey(first)) {
				map.put(first, first);
			}
			for (int j = 1; j < emails.size(); ++j) {
				if (map.containsKey(emails.get(j))) {
					union(map, first, emails.get(j));
				} else {
					map.put(emails.get(j), first);
				}
			}
		}
		System.out.println(map.size());
		Map<String, List<String>> res = new HashMap<String, List<String>>();
		for (String s : map.keySet()) {
			String anscestor = getAnscestor(map, s);
			if (!res.containsKey(anscestor)) {
				res.put(anscestor, new ArrayList<String>());
			}
			res.get(anscestor).add(s);
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for (List<String> l : res.values()) {
			result.add(l);
			for (String s : l) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		return result;
	}
	
	private static String getAnscestor(Map<String, String> map, String s) {
		while (!s.equals(map.get(s))) {
			String grandparent = map.get(map.get(s));
			map.put(s, grandparent);
			s = grandparent;
		}
		return s;
	}
	
	private static void union(Map<String, String> map, String s1, String s2) {
		String anscestor1 = getAnscestor(map, s1);
		String anscestor2 = getAnscestor(map, s2);
		map.put(anscestor1, anscestor2);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		list.add(l);
		l = new ArrayList<String>();
		l.add("d");
		l.add("b");
		l.add("c");
		list.add(l);l = new ArrayList<String>();
		l.add("e");
		l.add("f");
		l.add("g");
		list.add(l);l = new ArrayList<String>();
		l.add("h");
		list.add(l);l = new ArrayList<String>();
		l.add("c");
		l.add("j");
		l.add("k");
		list.add(l);
		mergeEmailList(list);
		
	}
}
