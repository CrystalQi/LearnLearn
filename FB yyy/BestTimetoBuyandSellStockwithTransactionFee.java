package Facebook;

import java.util.ArrayList;
import java.util.List;

public class BestTimetoBuyandSellStockwithTransactionFee {
	public static int maxProfit(int[] prices, int fee) {
		int res = 0;
		List<Interval> intervals = new ArrayList<Interval>();
		int start = 0;
		int end = 0;
		
		for (int i = 1; i < prices.length; ++i) {
			while (i < prices.length && prices[i - 1] >= prices[i]) {
				start = i;
				++i;
			}
			while (i < prices.length && prices[i - 1] < prices[i]) {
				end = i;
				++i;
			}
			intervals.add(new Interval(prices[start], prices[end]));
			--i;
		}
		for (int j = 0; j < intervals.size(); ++j) {
			System.out.println("[" + intervals.get(j).start + "," + intervals.get(j).end + "]");
		}
		int i = 0;
		while (i < intervals.size() - 1) {
			if (intervals.get(i+1).end > intervals.get(i).end 
					&& intervals.get(i+1).start > intervals.get(i).start
					&& intervals.get(i).end - intervals.get(i + 1).start <= fee) {
				intervals.add(i, 
						new Interval(Math.min(intervals.get(i).start, intervals.get(i + 1).start), 
								intervals.get(i + 1).end));
				++i;
				intervals.remove(i);
				intervals.remove(i);
			} else if (intervals.get(i).end - intervals.get(i).start <= fee) {
				intervals.remove(i);
			} else {
				++i;
			}
		}
		
		for (int j = 0; j < intervals.size(); ++j) {
			System.out.println("[" + intervals.get(j).start + "," + intervals.get(j).end + "]");
			res += intervals.get(j).end - intervals.get(j).start;
			res -= fee;
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,3,6,4,7};
		System.out.println(maxProfit(arr, 2));
		
		
	}
	
}

class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
