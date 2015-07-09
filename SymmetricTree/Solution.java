package SymmetricTree;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		return isMirrorTree(left,right);
	}
	
    public boolean isMirrorTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
        	return true;
        else if(p!=null&&q==null)
        	return false;
        else if(p==null&&q!=null)
        	return false;
        if(isMirrorTree(p.left,q.right)&&isMirrorTree(p.right,q.left)){
        	if(p.val==q.val)
        		return true;
        	else
        		return false;
        }
        else 
        	return false;
    }
}
