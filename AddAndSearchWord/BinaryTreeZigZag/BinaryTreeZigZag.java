package BinaryTreeZigZag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
	     public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	         ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	         LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
	         int level = 0;
	         if(root != null) 
	             currentLevel.add(root);
	        while(!currentLevel.isEmpty()){
	             LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
	            ArrayList<Integer> list = new ArrayList<Integer>();
	             for(TreeNode node : currentLevel){
	                list.add(node.val);
	                if(node.left != null)
	                     nextLevel.add(node.left);
	                if(node.right != null)
	                     nextLevel.add(node.right);
	            }
	             if(level%2 == 1)
	                Collections.reverse(list);
	            ans.add(list);
	             currentLevel = nextLevel;
	             level++;
	         }
	         return ans;
	     }
	 }
public class BinaryTreeZigZag {
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
		System.out.println(s.zigzagLevelOrder(a1));
	}
}
