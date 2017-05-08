public class Solution {
    public boolean search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<end){
            int mid=(end-start)/2+start;
            if(target==nums[mid]) return true;
            if(nums[mid]<nums[end]){
                if(target>nums[mid]&&target<=nums[end]) start=mid+1;
                else end=mid-1;
            }else if(nums[mid]>nums[end]){
                if(target<nums[mid]&&target>=nums[start]) end=mid-1;
                else start=mid+1;
            }else{
                end--;
            }
        }
        return nums[start]==target?true:false;
    }
}