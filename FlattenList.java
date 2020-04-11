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
        // Traverse till the end of the list
        while(copyHead != null){
            
            // If a Node has a child call the function
            if(copyHead.child!=null){
                copyHead = flattenNode(copyHead, copyHead.child);
            }
            
            copyHead = copyHead.next;
        }
        
        return head;
    }

    // This function flattens the given Node and its child. Does not flatten all the way down
    public static Node flattenNode(Node parent, Node child){
        
        Node temporaryNode = child;

        // Traverse till the end of the child list
        while(temporaryNode.next != null){
            temporaryNode = temporaryNode.next;
        }

        // Connect the end of the child list to the next node of the parent
        temporaryNode.next = parent.next;
        
        // Make the previous node of the parents current next to be the end of the child list. Exception Handling in case the parent is the last node of the list
        try{
            parent.next.prev = temporaryNode;
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        // Make the parent's next node the child node

        parent.next = child;
        
        // Make the child's previous node its parent
        child.prev = parent;
        
        // "Delete" the child node
        parent.child = null;
        
        return parent;
    }
    
}