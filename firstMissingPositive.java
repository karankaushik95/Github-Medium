// https://leetcode.com/problems/first-missing-positive/

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        for(int i = 0;i<nums.length; i++){
            while(nums[i]>0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i] -1] = nums[i];
                nums[i] = temp;
            }
        }
        
        
        for(int min = 0;min<nums.length;min++){
            if(nums[min] != min+1){
                return min+1;
            }
        }
        return nums.length+1;
    }
}