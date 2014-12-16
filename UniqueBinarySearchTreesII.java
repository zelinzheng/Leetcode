/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    
    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        
        if(start>end) {
            ret.add(null);
            return ret;
        }
        
        for(int i=start; i<=end; i++) {
            List<TreeNode> lefts = dfs(start, i-1);
            List<TreeNode> rights = dfs(i+1, end);
            
            for(TreeNode left:lefts) {
                for(TreeNode right:rights) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = left;
                    temp.right = right;
                    ret.add(temp);
                }
            }
        }
        return ret;
    }
}