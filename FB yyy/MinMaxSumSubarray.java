package Facebook;

import java.util.Arrays;

public class MinMaxSumSubarray {
	public static int minMaxSum(int[] input, int k) {
        int res = 0;
        Arrays.sort(input); 
        for (int i = 0; i < input.length && input[i] <= k; i++) {
            for (int j = input.length - 1; j >= i; j--) {
                if (input[i] + input[j] <= k) {
                    res += (int)Math.pow(2, j - i); // calculate the num of all combinations including i as start and maximum j as end;
                    break;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{6, 1, 4, 3, 5, 2};
		int res = minMaxSum(arr, 7);
		System.out.print(res);
	}
}
