/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pAncestors = new ArrayList<TreeNode>();
        ArrayList<TreeNode> qAncestors = new ArrayList<TreeNode>();
        findAncestors(root,p,pAncestors);
        findAncestors(root,q,qAncestors);
        
        for(int i=pAncestors.size()-1;i>=0;i--){
            if(qAncestors.contains(pAncestors.get(i))){
                return pAncestors.get(i);
            }
        }
        
        return null;
        
    }
    
    
    public void findAncestors(TreeNode root, TreeNode target, ArrayList<TreeNode> ancestors){
        if(root==null)
            return;
        else{
            if(root.val==target.val){
                ancestors.add(target);
                return;
            }
            else {
                if(root.left !=null){
                    ancestors.add(root);
                    findAncestors(root.left, target,ancestors);
                    if(!ancestors.contains(target)){
                        ancestors.remove(root);
                    }else{
                        return;
                    }
                }
                if(root.right !=null){
                    ancestors.add(root);
                    findAncestors(root.right,target,ancestors);    
                    
                    if(!ancestors.contains(target)){
                        ancestors.remove(root);
                    }
                }
            }
        }
    }
}