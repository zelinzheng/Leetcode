/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<TreeNode> ();
    TreeNode cur = null;
    public BSTIterator(TreeNode root) {
        if(root!=null) {
            stack.push(root);
            cur = root;
            while(cur.left!=null) {
                stack.push(cur.left);
                cur = cur.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       return (cur != null);
    }

    /** @return the next smallest number */
    public int next() {
        int next = cur.val;
        stack.pop();
        if(cur.right!=null) {
            stack.push(cur.right);
            cur = cur.right;
            while(cur.left!=null) {
                stack.push(cur.left);
                cur = cur.left;
            }
        }else {
                if(stack.size()!=0)cur = stack.peek();
                else cur = null;
        }
        return next;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
