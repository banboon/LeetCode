package MaximumDepthofBinaryTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	
	private int max=0;
	
    public int maxDepth(TreeNode root) {
    	if(root==null)
    		return 0;
    	if(root.left==null&&root.right==null)
    		return 1;
    	int i=0;
    	measure(root,i);
        return max;
    }
    
    public void measure(TreeNode root, int i){
    	if(root==null)
    		return;
    	i++;
    	measure(root.left,i);
    	measure(root.right,i);
    	if(i>max)
    		max=i;
    }
}
