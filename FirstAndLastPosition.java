// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int bin = Arrays.binarySearch(nums,target);
        if(bin<0){
            return new int[]{first,last};
        }
        first = bin;
        last = bin;
        while(first>=0&&nums[first]==target){
            first--;
        }
        while(last<nums.length&&nums[last]==target){
            last++;
        }
        
        return new int[]{first+1, last-1};
    }
}