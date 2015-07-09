package BinaryTreeLevelOrderTraverseII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public List<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root==null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		while(!stack.empty()){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			Stack<TreeNode> stack2 = new Stack<TreeNode>();
			while(!stack.empty()){
				TreeNode t = stack.pop();
				temp.add(t.val);
				if(t.left!=null)
					stack2.push(t.left);
				if(t.right!=null)
					stack2.push(t.right);
			}
			while(!stack2.empty()){
				stack.push(stack2.pop());
			}
			result.add(0,temp);
		}
		return result;

	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left=left;
		Solution s = new Solution();
		s.levelOrderBottom(root);
	}
}