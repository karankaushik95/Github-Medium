/**
 * https://leetcode.com/problems/odd-even-linked-list
 * 
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(! (head==null)){
            ListNode temp = head;
            ListNode temp2 = head.next;
            while(temp != null && temp2!=null){
                if(temp2.next!=null){
                    ListNode temp3 = temp2.next;
                    temp2.next = temp3.next;
                    temp3.next = temp.next;
                    temp.next= temp3;    
                }
                temp = temp.next;
                temp2 = temp2.next;
                
            }
        }
        return head;
    }
}