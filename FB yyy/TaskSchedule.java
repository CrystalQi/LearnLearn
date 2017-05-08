package Facebook;

import java.util.HashMap;
import java.util.Map;


/**
 * Task那道题，很多面经都提到过。
 * 就是比如给你一串task，再给一个cooldown，执行每个task需要时间1，
 * 两个相同task之间必须至少相距cooldown的时间，问执行所有task总共需要多少时间。
 * 比如执行如下task：12323，假设cooldown是3。
 * 总共需要的时间应该是 1 2 3 _ _ 2 3，也就是7个单位的时间。
 * 再比如 1242353，假设cool down是4，那总共时间就是 1 2 4 _ _ _ 2 3 5 _ _ _ 3，也就是13个单位的时间
 * 
 * follow up  基于1，给出最优的排列，使得字符串最短。
 *
 */
public class TaskSchedule {
	public static int totalTime(int[] arr, int cooldown) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int idx = 0;
		Map<Integer, Integer> timeMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; ++i) {
			++idx;
			if (timeMap.containsKey(arr[i])) {
				idx = Math.max(idx, timeMap.get(arr[i]) + cooldown + 1);	
			}
			timeMap.put(arr[i], idx);
		}
		return idx;
	}
	
	public static String totalTimeII(int[] arr, int cooldown) {
		if (arr == null || arr.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		Map<Integer, Integer> timeMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; ++i) {
			++idx;
			if (timeMap.containsKey(arr[i])) {
				idx = Math.max(idx, timeMap.get(arr[i]) + cooldown + 1);	
			}
			int diff = idx - sb.length();
			while (diff > 1) {
				sb.append('_');
				--diff;
			}
			sb.append(arr[i]);
			timeMap.put(arr[i], idx);
		}
		return sb.toString();
	}
	
	public static int bestTaskOrder(int[] arr, int cooldown) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxTaskNum = 0;
		int max = 0;
		for (int task : arr) {
			if (!map.containsKey(task)) {
				map.put(task, 0);
			}
			map.put(task, map.get(task) + 1);
			if (map.get(task) == max) {
				++maxTaskNum;
			} else if (map.get(task) > max) {
				maxTaskNum = 1;
				max = map.get(task);
			}
		}
		
		return Math.max(arr.length, (max - 1) * (cooldown + 1) + maxTaskNum);
		
	}
	
	public static void main(String [] args) {
		int[] arr = new int[]{1,2,3,2,3};
		System.out.println(totalTime(arr, 3));
		System.out.println(totalTimeII(arr, 3));
		int[] arr2 = new int[]{1,1,1,2,2,2,3,3,3};
		System.out.println(bestTaskOrder(arr2, 2));
	}
}
