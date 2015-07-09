package PathSum;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root==null)
    		return false;
    	if(root.left!=null){
    		 if(hasPathSum(root.left,sum-root.val))
    			 return true;
    	}
    	if(root.right!=null){
    		 if(hasPathSum(root.right,sum-root.val))
    			 return true;
    	}
    	if(root.left==null&&root.right==null&&root.val==sum)
    		return true;
    	return false;
    }
}
public class PathSum { 
	public static void main(String[] args){
		TreeNode a1=new TreeNode(1);
		TreeNode a2=new TreeNode(2);
		TreeNode a3=new TreeNode(3);
		a1.left=a2;a1.right=a3;
		TreeNode a4=new TreeNode(4);
		a2.left=a4;
		TreeNode a5=new TreeNode(5);
		TreeNode a6=new TreeNode(6);
		a3.left=a5;a3.right=a6;
		Solution s =new Solution();
		System.out.println(s.hasPathSum(a1, 9));
	}
}
