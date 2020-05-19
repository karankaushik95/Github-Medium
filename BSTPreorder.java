/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal
 * 
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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<Integer>();
        if(! (root==null)){
            preorderRecursive(root,preorderList);
        }
        return preorderList;
    }
    
    public void preorderRecursive(TreeNode root, List<Integer> preorderList){
        if(root==null){
            return;
        }else{
            preorderList.add(root.val); // Add parent
            preorderRecursive(root.left, preorderList); // Go left
            preorderRecursive(root.right, preorderList); // Go right
        }
    }



}