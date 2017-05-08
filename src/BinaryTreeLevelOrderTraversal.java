import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Christina on 2/19/16.
 */
public class BinaryTreeLevelOrderTraversal {

    //O(n), sapce: the width 0f the tree
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) return rst;
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                list.add(curr.val);
                if (!(curr.left == null)) que.add(curr.left);
                if (!(curr.right == null)) que.add(curr.right);
            }
            rst.add(list);
        }
        return rst;
    }
}
