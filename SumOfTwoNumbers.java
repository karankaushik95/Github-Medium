// https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode start = new ListNode(-1);
        ListNode temp = start;
        
        // Add digits individually like school grade math
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry;
            
            // Is there a carry?
            if(sum>=10){
                temp.next = new ListNode(sum%10);
                carry = sum/10;
            }else{
                temp.next = new ListNode(sum);
                carry = 0;
            }
            
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
            
        }
        
        // If first number is longer than second number
        while(l1!=null){
            
            int sum = l1.val + carry;
            if(sum>=10){
                temp.next = new ListNode(sum%10);
                carry = sum/10;
            }else{
                temp.next = new ListNode(sum);
                carry = 0;    
            }
            
            temp = temp.next;
            
            l1 = l1.next;
        }

        // If second number is longer than first number
        while(l2!=null){
            int sum = l2.val + carry;
            if(sum>=10){
                temp.next = new ListNode(sum%10);
                carry = sum/10;
            }else{
                temp.next = new ListNode(sum);
                carry = 0;    
            }
            
            temp = temp.next;
            l2 = l2.next;
        }
        
        // If a carry is generated in any final step
        if(carry !=0){
            temp.next = new ListNode(carry);
        }
        
        
        return start.next;
    }
}