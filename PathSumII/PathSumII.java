package PathSumII;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
	ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<Integer> tempList = new ArrayList<Integer>();
    	if(root==null)
    		return resultList;
    	onePath(root,sum,tempList);	
    	return resultList;
    }
    public void onePath(TreeNode root, int sum, ArrayList<Integer> tempList){
    	tempList.add(root.val);
    	if(root.left!=null){
    		onePath(root.left, sum-root.val, tempList);
    	}
    	if(root.right!=null){
    		onePath(root.right,sum-root.val,tempList);
    	}
    	if(root.left==null&&root.right==null&&root.val==sum){
    		resultList.add(new ArrayList<Integer>(tempList)); 
    	}
    	tempList.remove(tempList.size()-1);
    }
}
public class PathSumII {
	public static void main(String[] args){
		TreeNode a1=new TreeNode(1);
		TreeNode a2=new TreeNode(2);
		TreeNode a3=new TreeNode(3);
		a1.left=a2;a1.right=a3;
		TreeNode a4=new TreeNode(4);
		a2.left=a4;
		TreeNode a5=new TreeNode(3);
		TreeNode a6=new TreeNode(6);
		a3.left=a5;a3.right=a6;
		Solution s =new Solution();
		System.out.println(s.pathSum(a1, 7));
	}
}
