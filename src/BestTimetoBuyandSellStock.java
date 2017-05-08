/**
 * Created by Christina on 1/4/16.
 */
public class BestTimetoBuyandSellStock {
    /***
     * 如果是up  一直到结束或者遇到有减小的地方
     * use min and max to keep track of the min and max number from the start till now
     * if there is one that less than min, get the best result till now and
     *  then update the min number and max number
     */
    //O(n), O(1)
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0], max = prices[0], rst = max - min;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = max = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
                rst = Math.max(rst, max - min);
            }
        }
        return Math.max(0, rst);
    }

    public static void main(String arg[]) {
        BestTimetoBuyandSellStock a = new BestTimetoBuyandSellStock();
        System.out.println(a.maxProfit(new int[]{2, 1, 4}));
    }
}
