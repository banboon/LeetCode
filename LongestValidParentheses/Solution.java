package LongestValidParentheses;

import java.util.ArrayList;

class Stack{
	private ArrayList<Integer> stack;
	private int cur;
	
	public Stack(){
		stack = new ArrayList<Integer>();
		cur=0;
	}
	
	public void push(int c){
		stack.add(c);
		cur++;
	}
	
	public int pop(){
		int r = stack.get(cur-1);
		stack.remove(cur-1);
		cur--;
		return r;
	}
	
	public int getLen(){
		return cur;
	}
	
}

public class Solution {
    public int longestValidParentheses(String s) {
    	if(s.length()<2)
    		return 0;
    	boolean[] count = new boolean[s.length()];
    	Stack stack = new Stack();
    	for(int i=0;i<s.length();i++){
    		if(s.charAt(i)=='('){
    			stack.push(i);
    		}
    		else{
    			int len = stack.getLen();
    			if(len>0){
    			    count[i]=true;
    			    
    			    count[stack.pop()]=true;
    			}
    		}
    	}
    	int max=0;
    	int temp=0;
    	for(int i=0;i<s.length();i++){
    		if(count[i]){
    			temp++;
    		}
    		else{
    			if(temp>max)
    				max=temp;
    			temp=0;
    		}
    	}
		if(temp>max)
			max=temp;

    	return max;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	String r = "(()()()))";
    	System.out.println(s.longestValidParentheses(r));
    }

}
