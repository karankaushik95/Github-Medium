// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (numsMap.containsKey(find)) {
                return new int[] { numsMap.get(find), i };
            }
            numsMap.put(nums[i], i);
        }
        
        
        return new int[] {};
    }
}