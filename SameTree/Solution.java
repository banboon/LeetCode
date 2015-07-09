package SameTree;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
        	return true;
        else if(p!=null&&q==null)
        	return false;
        else if(p==null&&q!=null)
        	return false;
        if(isSameTree(p.left,q.left)&&isSameTree(p.right,q.right)){
        	if(p.val==q.val)
        		return true;
        	else
        		return false;
        }
        else
        	return false;
    }
    
}
