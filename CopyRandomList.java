/*
* https://leetcode.com/problems/copy-list-with-random-pointer
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        // Empty list
        if(head == null){
            return null;
        }
        // Initialize the new list
        Node temp = head;
        Node newHead = new Node(head.val);
        Node temp2 = newHead;
        
        // Use a HashMap to creating a mapping between the nodes in the old list and the nodes in the deepcopy

        HashMap<Node,Node> nodeMap = new HashMap<Node,Node>();
        nodeMap.put(head,newHead);
        
        temp = temp.next;
        while(temp!=null){
            temp2.next = new Node(temp.val);
            nodeMap.put(temp,temp2.next);
            
            temp2 = temp2.next;
            temp = temp.next;
        }
        
        temp = head;
        temp2 = newHead;
        
        // Assign the random pointer
        while(temp!=null){
            if(temp.random!=null){
                temp2.random = nodeMap.get(temp.random);
            }
            temp2 = temp2.next;
            temp = temp.next;
        }
        
        
        return newHead;
    }
}