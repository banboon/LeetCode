package ConverSortedArrayToBST;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	private TreeNode root=null;

	public TreeNode sortedArrayToBST(int[] num) {
		if(num==null||num.length<1)
			return null;

		root=help(root,0,num.length-1,num);

		return root;

	}

	public TreeNode help(TreeNode root, int begin, int end,int[] num){
		if(begin>end)
			return null;
		int mid=(end+begin)/2;
		root=new TreeNode(num[mid]);
		root.left=help(root.left,begin,mid-1, num);
		root.right=help(root.right,mid+1,end,num);
		return root;
	}
}
