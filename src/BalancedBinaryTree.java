/**
 * Created by Christina on 2/23/16.
 */
public class BalancedBinaryTree {
    /**
     * 1. the left is balanced
     * 2. the right is balanced
     * 3. the depth difference of left and right are less than 2
     *
     * if is valid maximum depth return the depth of the tree
     * else return -1
     * use dfs, recursively use the method
     * */
    //dfs
    public boolean isBalanced(TreeNode root) {
        return getBalancedDepth(root) >= 0;
    }

    private int getBalancedDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getBalancedDepth(root.left);
        int right = getBalancedDepth(root.right);
        if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
           return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
