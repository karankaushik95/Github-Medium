/**
 * https://leetcode.com/problems/merge-two-binary-trees
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1==null && t2==null){
            return null;
        }
        
        TreeNode temp1 = new TreeNode(1);
        temp1.left = t1;
        
        TreeNode temp2 = new TreeNode(1);
        temp2.left = t2;
        
        mergeTree(temp1,temp2);
        
        return temp1.left;
        
    }

    public void mergeTree(TreeNode t1, TreeNode t2){
        
        if(t1.left==null && t2.left!=null){
            t1.left = t2.left;
            t2.left = null;
        }
        
        if(t1.right==null && t2.right!=null){
            t1.right = t2.right;
            t2.right = null;
        }
        
        t1.val += t2.val;
        if(t1.left!= null && t2.left!=null){
            mergeTree(t1.left,t2.left);
        }
        if(t1.right!= null && t2.right!=null){
            mergeTree(t1.right,t2.right);
        }
        
    }


}