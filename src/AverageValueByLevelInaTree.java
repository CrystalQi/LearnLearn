import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Christina on 2/20/16.
 */
public class AverageValueByLevelInaTree {

    /**
     * BFS to iterate the tree level by level
     * keep track of the sum of each level and calculate the average
     * test case: null, root without left & right subtrees, balanced, unbalanced
     * */
    //O(n), O(the width of the tree)
    public List<Integer> averageValueByLevelInaTree(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int sum = 0, count = size;
            while (size-- != 0) {
                TreeNode temp = que.poll();
                sum += temp.val;
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
            }
            ret.add(sum / count);
        }
        return ret;
    }

    public static void main(String[] arg) {
        AverageValueByLevelInaTree a = new AverageValueByLevelInaTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        System.out.println(a.averageValueByLevelInaTree(root));
    }
}
