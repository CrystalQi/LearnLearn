import java.util.*;

/**
 * Created by Christina on 12/22/15.
 */
public class _3Sum {

    //two pointers
    //O(n^2)  O(1)
    public List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    while (left < right && nums[left] == nums[left + 1]) { left++;}
                    while (left < right && nums[right] == nums[right - 1]) { right--;}
                    ret.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) { i++;}
        }
        return ret;
    }


    //hashmap
    //O(n^2), O(n)
    public List<List<Integer>> threeSum1(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int rest = target - nums[i] - nums[j];
                int count = 0;
                if (nums[i] == rest) {count++;}
                if (nums[j] == rest) {count++;}
                if (map.containsKey(rest) && map.get(rest) > count && rest >= nums[j]) {
                    ret.add(Arrays.asList(nums[i], nums[j], rest));
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) {j++;}
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {i++;}
        }
        return ret;
    }


    //every one can be duplicated
    //two pointers
    //O(n ^ 2)
    public List<List<Integer>> threeSum2 (int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i, right = nums.length - 1;
            while (left <= right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    while (left < right && nums[left] == nums[left + 1]) { left++;}
                    while (left < right && nums[right] == nums[right - 1]) { right--;}
                    ret.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) { i++;}
        }
        return ret;
    }

    public static void main(String[] arg) {
        _3Sum a = new _3Sum();
        System.out.println(a.threeSum(new int[]{-1, 0, 1, 2, -1, 4}, 0));
        System.out.println(a.threeSum1(new int[]{-1, 0, 1, 2, -1, 4}, 0));
        System.out.println(a.threeSum2(new int[]{-1, 0, 1, 2, -1, 4}, 0));

        System.out.println(a.threeSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(a.threeSum1(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(a.threeSum2(new int[]{0, 0, 0, 0, 0}, 0));


        System.out.println(a.threeSum2(new int[]{1}, 3));
    }
}
