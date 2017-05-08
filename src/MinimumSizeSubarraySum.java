/**
 * Created by Christina on 2/20/16.
 */
public class MinimumSizeSubarraySum {
    /**
     * Use two pointers, p1 points to the start, then p2 moves forward
     * until the sum equals or larger than the target, then get the current length
     * then moves p1 before the sum is less than target, update the length all the time
     * */

    //O(n), O(1)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int p1 = 0, p2 = 0, ret = Integer.MAX_VALUE, sum = 0;
        while (p2 < nums.length) {
            sum += nums[p2++];
            while (sum >= s) {
                ret = Math.min(ret, p2 - p1);
                sum -= nums[p1++];
            }
        }
        return ret == Integer.MAX_VALUE ? 0:ret;
    }

    public static void main(String[] arg) {
        MinimumSizeSubarraySum a = new MinimumSizeSubarraySum();
        System.out.println(a.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(a.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
