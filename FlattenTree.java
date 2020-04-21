// https://leetcode.com/problems/flatten-binary-tree-to-linked-list

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class FlattenTree {
    public void flatten(TreeNode root) {
        // Base case of recursion, if reached leaf or tree is null
        if(root==null){
            return;
        }
        
        // If there's a right node, recursively flatten it
        if(root.right != null){
            flatten(root.right);
        }
        
        // If the tree has a left
        if(root.left != null){
            flatten(root.left); // Flatten it recursively first
            
            // Go into its rightmost child
            TreeNode temp = root.left;
            
            while(temp.right != null){
                temp = temp.right;
            }
            
            // Attach it to the right child
            temp.right = root.right;
            root.right = root.left;
            
            root.left = null;
        }
    }
}
