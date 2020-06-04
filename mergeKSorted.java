/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * 
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // Empty list or no list
        if(lists.length==0 || lists==null){
            return null;
        }
        
        // Dummy head
        ListNode newHead = new ListNode(-1);
        
        // Attach dummyhead to first LL in the list
        newHead.next = lists[0];
        
        // Iterate over all the other lists, and merge elements one by one into the first list
        for(int i = 1; i<lists.length;i++){
            ListNode iter = lists[i];
            ListNode temp = newHead;
            while(iter!=null && temp.next !=null){
                // Found position to merge it into
                if(iter.val < temp.next.val){
                    ListNode copy = iter.next;
                    iter.next = temp.next;
                    temp.next = iter;
                    iter = copy;
                }
                
                temp = temp.next;
            }
            // Reached end of first list, but the list hasn't been completely merged
            if(iter!=null){
                temp.next = iter;
            }
            
        }
        
        return newHead.next;
    }
}