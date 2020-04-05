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
        
        if(root==null){
            return;
        }
        
        if(root.right != null){
            flatten(root.right);
        }
        if(root.left != null){
            flatten(root.left);
            TreeNode temp = root.left;
            while(temp.right != null){
                temp = temp.right;
            }    
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}