package BinaryTreeLevelOrderTraversal;

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
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s.push(root);
		if(root==null)
			return result;
		while(!s.empty()){
			List<Integer> temp = new ArrayList<Integer>();
			while(!s.empty()){
				TreeNode t = s.pop();
				temp.add(t.val);
				if(t.left!=null)
					s2.push(t.left);
				if(t.right!=null)
					s2.push(t.right);
			}
			result.add(temp);
			while(!s2.empty()){
				s.push(s2.pop());
			}
		}
		return result;
	}
}