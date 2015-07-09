package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
   
	List<String> result = new ArrayList<String>();
    
    public List<String> generateParenthesis(int n) {
        if(n<1)
            return null;
        help(n,n,0,"");
        return result;
    }
    
    public void help(int left, int right, int has, String previous){
    	if(left<1&&right<1){
    		result.add(previous);
    		return;
    	}
    	if(left<1){
    		for(int i=0;i<right;i++){
    			previous+=")";
    		}
    		result.add(previous);
    		return;
    	}
    	if(has<1){
    		previous+="(";
    		help(left-1,right,has+1,previous);
    	}
    	else{

    		help(left-1,right,has+1,previous+"(");
    		help(left,right-1,has-1,previous+")");  		
    	}
    }
    
    public static void main(String[] args){
    	
    	Solution s = new Solution();
    	System.out.println(s.generateParenthesis(1));
    }
}