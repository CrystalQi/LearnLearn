// sort and two pointers: O(n^2) time, O(1) space if not consider sorting's stack usage
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);//cannot be skipped if return boolean
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {//can be skipped if return boolean
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {//just return true below if return boolean
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {//remember to skip dups after adding result
                        left++;//can be skipped if return boolean
                    }
                    while (left < right && nums[right] == nums[right + 1]) {//remember to skip dups after adding result
                        right--;//can be skipped if return boolean
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
// hashtables without sort (dups may exist): O(n^2) time, O(n) space
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();//use this to store keys of combinations of 3nums that have been added to res
        for (int i : nums) {//counting sort, store the nums and their occurrences
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (int i : nums) {//first num
            map.put(i, map.get(i) - 1);//used num should occurrence - 1, and so that we can avoid dups created
            if (map.get(i) == 0) {
                map.remove(i);
            }
            for (int j : map.keySet()) {//second num
                int k = 0 - i - j;//third num
                if (!map.containsKey(k) || (k == j && map.get(k) == 1)) {//if k not found, or k==j and it only occurs once
                    continue;
                }
                
                //if we only need to determine whether 3sum exist, we can just return true here and skip the code below !!
                
                String key = getKey(i, j, k);//use this key to determine whether it's a duplicated result
                if (!set.contains(key)) {//if this combination of three nums hasn't been added to res
                    res.add(new ArrayList<>(Arrays.asList(i, j, k)));
                    set.add(key);//remember to add it into set
                }
            }
        }
        return res;
    }
    
    private String getKey(int i, int j, int k) {//why only care min&max?cuz when target is fixed,target-min-max is fixed too!
        int min = Math.min(Math.min(i, j), k);//min, min !!!
        int max = Math.max(Math.max(i, j), k);//max, max !!!
        return String.valueOf(min) + "@" + String.valueOf(max);
    }
}

// hashtables without sort (if no dups in nums and each num can only be used once): O(n^2) time, O(n) space
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        HashSet<Integer> vals = new HashMap<>();
        for (int i : nums) {
            if (!vals.contains(i)) {
                vals.add(i);
            }
        }
        for (int i : vals) {//first num
            for (int j : vals) {//second num
                int k = 0 - i - j;//third num
                // if (i == j || i == k || j == k) {//if two of three are the same, skip
                //     continue;
                // }
                if (!vals.contains(k)) {//if k not found
                    continue;
                }
                res.add(new ArrayList<>(Arrays.asList(i, j, k)));
            }
        }
        return res;
    }
}

// if each num can be used for any times(results should still be unique):
// hashtables without sort: O(n^2) time, O(n) space
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        HashSet<Integer> vals = new HashSet<>();
        for (int i : nums) {
            if (!vals.contains(i)) {
                vals.add(i);
            }
        }
        for (int i : vals) {//first num
            for (int j : vals) {//second num
                int k = 0 - i - j;//third num
                if (!vals.contains(k)) {//if k not found
                    continue;
                }
                res.add(new ArrayList<>(Arrays.asList(i, j, k)));
            }
        }
        return res;
    }
}
// if each num can be used for any times(results should still be unique):
// sort and two pointers: O(n^2) time, O(1) space if not consider sorting's stack usage
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {//i < nums.length if each num can be used for any times
            if (i != 0 && nums[i] == nums[i - 1]) {//skip duplicated 3sum results
                continue;
            }
            int left = i;//start from i if each num can be used for any times
            int right = nums.length - 1;
            while (left <= right) {//left <= right if each num can be used for any times
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {//remember to skip dups after adding result
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {//remember to skip dups after adding result
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}