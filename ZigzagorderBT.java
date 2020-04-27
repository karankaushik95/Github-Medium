/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> zigzagOrder = new ArrayList<List<Integer>>();
        
        if(root==null){
            return zigzagOrder;
        }
        
        
        levelOrderTraversal(root, zigzagOrder, 0);
        
        for(int i=1;i<zigzagOrder.size();i+=2){
            Collections.reverse(zigzagOrder.get(i));
        }
        
        return zigzagOrder;
        
        
    }

    public void levelOrderTraversal(TreeNode root, ArrayList<List<Integer>> levelOrderList, int level){
        if(levelOrderList.size()==level){
            ArrayList<Integer> thislevel = new ArrayList<Integer>();
            levelOrderList.add(level,thislevel);
        }
        
        levelOrderList.get(level).add(root.val);
        if(root.left!=null){
            levelOrderTraversal(root.left,levelOrderList,level+1);
        }
        
        if(root.right!=null){
            levelOrderTraversal(root.right,levelOrderList,level+1);
        }
        
    }

}