package Facebook;

import java.util.Stack;


public class BstToDoublyList {
	public TreeNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = null;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (head == null) {
                head = cur;
                last = cur;
            } else {
                last.right = cur;
                cur.left = last;
                last = last.right;
            }
            if (cur.right != null) {
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        if (cur != null && head != null) {
        	cur.right = head;
        	head.left = cur;
        }
        return head;
    }
}