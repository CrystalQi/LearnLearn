package Facebook;


class ListNode {
	String val;
	ListNode next;
	ListNode(String val) {
		this.val = val;
		next = null;
	}
}


public class SerializeandDeserializeBinaryTree {
	ListNode head = null;
	ListNode cur = head;
	
	public ListNode serialize(TreeNode root) {
        serializeHelper(root);
        return head;
    }
	
    public void serializeHelper(TreeNode root) {
        if (root == null) {
        	ListNode node = new ListNode("#");
        	if (head == null) {
            	head = node;
            	cur = node;
            } else {
            	cur.next = node;
            	cur = cur.next;
            }
        	return;
        }

        ListNode node = new ListNode(String.valueOf(root.val));
        if (head == null) {
        	head = node;
        	cur = node;
        } else {
        	cur.next = node;
        	cur = cur.next;
        }
        serialize(root.left);
        serialize(root.right);
    }

    
    public TreeNode deserialize(ListNode head) {
        this.head = head;
        cur = head;
        return deserializeHelper();
    }
    private TreeNode deserializeHelper() {
        if (cur.val.equals("#")) {
        	cur = cur.next;
        	return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur.val));
        cur = cur.next;
        root.left = deserializeHelper();
        root.right = deserializeHelper();
        
        return root;
    }
    
    
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		printTree(root);
		System.out.println();
		SerializeandDeserializeBinaryTree sdbt = new SerializeandDeserializeBinaryTree();
		ListNode node = sdbt.serialize(root);
		ListNode cur = node;
		while (cur != null) {
			System.out.print(cur.val + ",");
			cur = cur.next;
		}
		System.out.println();
		TreeNode treeNode = sdbt.deserialize(node);
		printTree(treeNode);
	}
	
	public static void printTree (TreeNode root) {
    	if (root == null) {
    		System.out.print("#,");
    		return;
    	}
    	System.out.print(root.val + ",");
    	printTree(root.left);
    	printTree(root.right);
	}
}

