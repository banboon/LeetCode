package simplyPath;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        
        if(path==null)
            return null;
        
        if(path.equals("/../"))
            return "/";
            
        Stack<String> stack = new Stack<String>();
        String[] p = path.split("/");
        for(int i=0;i<p.length;i++){
            if(p[i].equals("."))
                ;
            else if(p[i].equals("..")){
                if(stack.empty()){
                    ;
                }
                else{
                    stack.pop();
                }
            }
            else{
                stack.push(p[i]);
            }
        }
        StringBuffer buf = new StringBuffer();
        while(!stack.empty()){
            buf.append("/");
            buf.append(stack.pop());
        }
        String result=buf.toString();
        if(result.equals("")||result==null)
            result="/";
        return result;
    }
    
    public static void main(String[] args){
    	String input = "/...";
    	Solution s = new Solution();
    	System.out.println(s.simplifyPath(input));
    }
}