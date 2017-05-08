package Facebook;

public class MaximumProductSubarrayII {
	public static int[] maxProduct(int[] nums) {
        if (nums.length < 1) {
            return new int[]{0, 0};
        }
        int maxStart = 0;
        int minStart = 0;
        int[] res = new int[]{0, 0};
        
        int max = Integer.MIN_VALUE;
        int maxProd = 1;
        int minProd = 1;
        for (int i = 0; i < nums.length; ++i) {
            int maxCopy = maxProd;
            int minCopy = minProd;
            int maxStartCopy = maxStart;
            int minStartCopy = minStart;
            maxProd = Math.max(Math.max(maxCopy * nums[i], minCopy * nums[i]), nums[i]);
            minProd = Math.min(Math.min(maxCopy * nums[i], minCopy * nums[i]), nums[i]);
            
            if (maxProd == nums[i]) {
            	maxStart = i;
            } else if (maxProd == minCopy * nums[i]) {
            	maxStart = minStartCopy;
            } 
            
            if (minProd == nums[i]) {
            	minStart = i;
            } else if (minProd == maxCopy * nums[i]) {
            	minStart = maxStartCopy;
            }
            
            if (maxProd >= max) {
            	res[0] = maxStart;
            	res[1] = i;
            	max = maxProd;
            }
            
            
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,0,-2,-4};
		int[] pos = maxProduct(arr);
		System.out.println(pos[0]);
		System.out.println(pos[1]);
	}
}
