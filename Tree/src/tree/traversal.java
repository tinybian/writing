package tree;

import java.util.*;

class Traversal {

    List<Integer> result = new ArrayList<Integer>();//�������
	//����ݹ�
    public List<Integer> preorderTrvRecursion(TreeNode root) {
        if(root!=null)
        {
        	result.add(root.val);
	        if(root.left!=null)
	        	preorderTrvRecursion(root.left);
	        if(root.right!=null)
	        	preorderTrvRecursion(root.right);
        }
		return result;
    }
    //�������
    public List<Integer> preorderTrvIterative(TreeNode root){
    	Stack<TreeNode> stack = new Stack<>();
    	if(root!=null)
    		stack.push(root);
    	while(!stack.isEmpty())
    	{
        	TreeNode node = stack.pop();
    		result.add(node.val);
    		if(node.right!=null)
    			stack.push(node.right);
    		if(node.left!=null)
    			stack.push(node.left);
    	}
    	return result;
    }
    //����ݹ�
    public List<Integer> inorderTrvRecursion(TreeNode root) {
    	if(root!=null)
    	{
	        if(root.left!=null)
	        	inorderTrvRecursion(root.left);
	        result.add(root.val);
	        if(root.right!=null)
	        	inorderTrvRecursion(root.right);
    	}
        
		return result;
    }
    //�������
    public List<Integer> inorderTrvIterative(TreeNode root){
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	while(root != null || !stack.empty()){
    		if(root != null){
    			stack.push(root);
    			root = root.left;
    		}
    		else{
    			root = stack.pop();
    			result.add(root.val);
    			root = root.right;
    		}
    	}
    	
    	return result;
    }
    
    //����ݹ�
    public List<Integer> postorderTrvRecursion(TreeNode root){
    	if(root != null){
    		if(root.left != null)
    			postorderTrvRecursion(root.left);
    		if(root.right != null)
    			postorderTrvRecursion(root.right);
    		result.add(root.val);
    	}
    	
    	return result;
    }
    
    //�������
    public List<Integer> postorderTrvIterative(TreeNode root){
    	Stack<TreeNode> stack = new Stack<>();
    	Stack<TreeNode> output = new Stack<>();//����һ���м�ջ���洢���������Ľ��
    	
    	while(root != null || !stack.empty()){
    		if(root != null){
    			stack.push(root);
    			output.push(root);
    			root = root.right;
    		}
    		else {
    			root = stack.pop();
    			root = root.left;
    		}
    	}
    	
    	while(!output.empty()){
    		result.add(output.pop().val);
    	}
    	
    	return result;
    }
    
    //�ǵݹ�������
    public List<Integer> postTraverse(TreeNode root) {
    	Stack<TreeNode> s = new Stack<>();
    	TreeNode p = root;
    	//pre��������ջ�Ľڵ㣬�����ж��Ƿ���p�ڵ���Һ��ӣ�����ǵĻ����Ϳ��Է���p�ڵ�
    	TreeNode pre = p;
    	
    	boolean flag = true;//flag����ǳ�ջ���Ǽ��������ӽ�ջ
    	while(p!=null || !s.isEmpty()) {
    		if(p!=null && flag) {
    			s.push(p);
    			p = p.left;
    		}
    		else {
    			if(s.isEmpty()) 
    				return result;
    			p = (TreeNode)s.peek();
    			if(p.right != null && p.right!=pre) {
    				p = p.right;
    				flag = true;
    			}
    			else {
    				p = (TreeNode)s.pop();
    				result.add(p.val);
    				flag = false;
    				pre = p;
    			}
    		}
    	}
    	return result;
	}
    
    //�������
    public List<Integer> levelorderTrv(TreeNode root){
    	LinkedList<TreeNode> queue = new LinkedList<>();

    	if(root != null)
    		queue.add(root);
    	while(queue.size() > 0){
    		root = queue.poll();
    		result.add(root.val);
    		if(root.left != null)
    			queue.add(root.left);
    		if(root.right != null)
    			queue.add(root.right);
    	}
    	
    	return result;
    }
}