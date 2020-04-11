/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
     
        Node copyHead = head;
        while(copyHead != null){
            
            if(copyHead.child!=null){
                copyHead = flattenNode(copyHead, copyHead.child);
            }
            
            copyHead = copyHead.next;
        }
        
        return head;
    }

    public static Node flattenNode(Node parent, Node child){
        
        Node temporaryNode = child;
        while(temporaryNode.next != null){
            temporaryNode = temporaryNode.next;
        }
        temporaryNode.next = parent.next;
        try{
            parent.next.prev = temporaryNode;
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        parent.next = child;
        child.prev = parent;
        parent.child = null;
        return parent;
    }
    
}