package Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个linkedlist，里面的element都排序好了，但是是一个blackbox，有三个function可以调用。
 * pop()随机pop出最前面或最后面的element，peek()随机偷看最前面或最后面的element，isEmpty()回传linkedlist是不是空了。
 * 问设计一个资料结构，list或是array都可以，把linkedlist里面所有的element都拿出来，并保持他们的排序。
 * 
 * followup是如果不能用peek()该怎么做。
 *
 */
public class BlackboxLinkedListDesign {
	public List<Integer> sortList(CustomizeQueue queue) {
		
		List<Integer> minArr = new ArrayList<Integer>();
		List<Integer> maxArr = new ArrayList<Integer>();
		
		while (!queue.isEmpty()) {
			int num = queue.pop();
			int peek = queue.peek();
			if (num < peek) {
				minArr.add(num);
			} else {
				maxArr.add(0, num);
			}
		}
		
		minArr.addAll(maxArr);
		return minArr;
	}
	
	// no peek()
	public List<Integer> sortListII(CustomizeQueue queue) {
		List<Integer> minArr = new ArrayList<Integer>();
		List<Integer> maxArr = new ArrayList<Integer>();
		if (queue.isEmpty()) {
			return minArr;
		}
		int last = queue.pop();
		while (!queue.isEmpty()) {
			int cur = queue.pop();
			if (cur > last) {
				minArr.add(last);
			} else {
				maxArr.add(0, last);
			}
			last = cur;
		}
		minArr.add(last);
		minArr.addAll(maxArr);
		return minArr;
	}
}

class CustomizeQueue {
	
	public int pop() {
		return 0;
	}
	
	public int peek() {
		return 0;
	}
	
	public boolean isEmpty() {
		return false;
	}
}
