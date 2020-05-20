/**
 * 
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    private ArrayList<Integer> nodesList;
    private int index;
    
    
    public BSTIterator(TreeNode root) {
        nodesList = new ArrayList<Integer>();
        index = 0;
        inorderTraversal(root,nodesList);
    }
    
    /** @return the next smallest number */
    public int next() {
        return nodesList.get(index++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index!=nodesList.size();
    }
    
    private void inorderTraversal(TreeNode root, ArrayList<Integer> nodesList){
        if(root==null){
            return;
        }
        if(root.left!=null){
            inorderTraversal(root.left, nodesList);
        }
        nodesList.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right, nodesList);
        }
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */