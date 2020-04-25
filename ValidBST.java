/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        ArrayList<Integer> traversalList = new ArrayList<Integer>();
        inorderTraversal(root, traversalList);
        for(int i =0; i<traversalList.size()-1;i++){
            if(traversalList.get(i)>=traversalList.get(i+1)){
                return false;
            }
        }
        return true;
    }
        
    public void inorderTraversal(TreeNode root, ArrayList<Integer> traversalList){
        if(root.left!=null){
            inorderTraversal(root.left, traversalList);
        }
        traversalList.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right, traversalList);
        }
    }

}