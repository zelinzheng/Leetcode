/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null) return ret;
        
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ret.add(0, cur.val);
            
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
        
        return ret;
    }
}