public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class NthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // A Dummy pointer to keep track of the list
        ListNode start = new ListNode(-1);
        start.next = head;
        
        ListNode end = start;
        ListNode dummy = start;
        
        // Create a gap of n between the start and the end
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        
        // Now keep advancing until we reach the end of the list
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        // Free the delete!
        start.next = start.next.next;
        
        // For when the start of the list needs to be deleted, if that makes sense. Otherwise the head pointer will always be kept and returned which would not work.
        return dummy.next;

    }

}