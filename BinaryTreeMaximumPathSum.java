/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeMaximumPathSum  {
    public int maxPathSum(TreeNode root) {
        int[] ret = new int[1];
        ret[0] = root==null?0:root.val;
        maxPathSum(root, ret);
        return ret[0];
    }
    
    public int maxPathSum(TreeNode root, int[] ret) {
        if(root == null) return 0;
        int left = maxPathSum(root.left,ret);
        int right = maxPathSum(root.right,ret);
        if(left+right+root.val>ret[0]) ret[0] = left+right+root.val;
        return Math.max(Math.max(left,right ) + root.val,0);
    }
}