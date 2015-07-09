package ImplementStrstr;

public class Solution {


	    public String strStr(String haystack, String needle) {
	        
	        if(haystack==null||needle==null)
	            return null;
	            
	        if(haystack==""){
	            return needle==""?"":null;
	        }
	        
	        if(needle==""){
	            return haystack;
	        }
	            
	        for(int i=0;i<=haystack.length()-needle.length();i++){
	            if(haystack.charAt(i)==needle.charAt(0)){
	                if(haystack.substring(i,i+needle.length()).equals(needle))
	                    return haystack.substring(i);
	            }
	        }
	        
	        return null;    
	
	}
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.strStr("mississippi", "issip"));
    }
}