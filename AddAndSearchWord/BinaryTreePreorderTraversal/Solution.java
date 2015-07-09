package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	
	private ArrayList<Integer> result = new ArrayList<Integer>();
	
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
        	return result;
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
        
    }
}

/*
import java.util.*;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root != null){
            ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

            stack.addFirst(root);
            while (!stack.isEmpty()) {
                TreeNode n = stack.removeFirst();
                result.add(n.val);
                if (n.right != null) stack.addFirst(n.right);
                if (n.left != null) stack.addFirst(n.left);
            }
        }
        return result;
    }
}
*/
