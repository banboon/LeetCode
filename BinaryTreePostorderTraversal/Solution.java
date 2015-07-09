package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	
	private ArrayList<Integer> result=new ArrayList<Integer>();
	private ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
	
    public List<Integer> postorderTraversal(TreeNode root) {
    	if(root==null)
    		return result;
    	stack.add(root);
    	while(!stack.isEmpty()){
    		TreeNode cur = stack.remove(0);
    		result.add(0,cur.val);
    		if(cur.left!=null)
    			stack.add(0,cur.left);
    		if(cur.right!=null)
    			stack.add(0,cur.right);
    	}
    	return result;
    }
    
    public static void main(String[] args){
    	TreeNode l1 = new TreeNode(1);
    	TreeNode l2 = new TreeNode(2);
    	l1.left=l2;
    	Solution s = new Solution();
    	System.out.println(s.postorderTraversal(l1));
    }
}
