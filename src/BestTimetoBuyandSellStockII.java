/**
 * Created by Christina on 2/21/16.
 */
public class BestTimetoBuyandSellStockII {

    /**
     * use min and max to keep track of the local min & max
     * if there is one less than the min, than implement a transaction, the profit is max - min
     * then update the min and max number
     * */


    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0], max = prices[0], rst = 0;
        for (int i = 1; i < prices.length; i++) {
            if (i == prices.length - 1) {
                max = Math.max(prices[i], max);
                rst += max - min;
                break;
            }
            if (prices[i] > max) {
                max = prices[i];
            } else if (prices[i] < max) {
                rst += max - min;
                max = min = prices[i];
            }
        }
        return rst;
    }


    //even better
    public int maxProfit1(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }


    public static void main(String[] arg) {
        BestTimetoBuyandSellStockII a = new BestTimetoBuyandSellStockII();
        System.out.println(a.maxProfit(new int[]{1, 2, 5, 3, 6, 9}));
        System.out.println(a.maxProfit1(new int[]{1, 2, 5, 3, 6, 9}));
    }
}
