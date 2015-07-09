package ConstructTreeI;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if(preorder.length<1)
			return null;

		if(preorder.length==1)
			return new TreeNode(preorder[0]);

		int start=0;
		int end=preorder.length-1;

		TreeNode root = new TreeNode(0);

		help(root, preorder, inorder, start, end, start, end);

		return root;
	}

	public void help(TreeNode root, int[] pre, int[] in, int pre_start, int pre_end, int in_start, int in_end){

		root.val=pre[pre_start];

		if(pre_start>=pre_end){
			return;
		}

		int i;
		for(i=in_start;i<=in_end;i++){
			if(in[i]==pre[pre_start])
				break;
		}
		if(i>in_start){
			root.left = new TreeNode(0);
			help(root.left, pre,in, pre_start+1,pre_start+i-in_start, in_start, i-1);
		}
		if(in_end>i){
			root.right = new TreeNode(0);
			help(root.right, pre, in, pre_start+1+i-in_start, pre_end, i+1,in_end);
		}
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] p = {1,2};
		int[] i ={2,1};
		s.buildTree(p, i);
	}

}
