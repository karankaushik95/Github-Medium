// https://leetcode.com/problems/boats-to-save-people

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int noOfBoats = 0;
        
        // Sort the array
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        
        while(start<=end){
            noOfBoats++; // Heaviest always gets a boat
            
            // If lightest has space to fit in it, accommodate him and move the pointer
            if(people[start]+people[end]<=limit)
                start++;
            
            end--;
        }
        
        return noOfBoats;
    }
}
