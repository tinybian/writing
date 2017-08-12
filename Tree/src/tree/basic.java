package tree;

import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

class Main{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		
		Traversal tra = new Traversal();
		//System.out.println(tra.postorderTrvIterative(root).toString());

    	List<TreeNode> queue = new LinkedList<>();
    	System.out.println(queue instanceof LinkedList);
	}
}