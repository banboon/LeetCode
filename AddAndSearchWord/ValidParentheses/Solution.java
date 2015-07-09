package ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        if(s==null)
            return false;
        
        char[] array = s.toCharArray();
        
        for(int i=0;i<array.length;i++){
            if(array[i]=='('||array[i]=='['||array[i]=='{'){
                stack.push(new Character(array[i]));
            }
            else{
                if(stack.empty())
                    return false;
                else{
                    char temp = stack.pop();
                    if(temp!=array[i])
                        return false;
                }
            }
        }
        
        if(stack.empty())
            return true;
        else{
            return false;
        }
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.isValid("()"));
    	
    	
    }
}