/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree  {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean left = isValid(root.left, Integer.MIN_VALUE, root.val);
        boolean right = isValid(root.right, root.val, Integer.MAX_VALUE);
        
        return left&&right;
    }
    
    private boolean isValid(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.val<= min || root.val>= max) return false;
        boolean left = isValid(root.left, min, root.val);
        boolean right = isValid(root.right, root.val, max);
        
        return left&&right;
    }
    
}