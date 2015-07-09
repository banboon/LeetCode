package PalindromePartition;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	private List<List<String>> result = new ArrayList<List<String>>();
	private ArrayList<String> dict = new ArrayList<String>();
	
    boolean isPalindrome(String s) {
    	char[] c=s.toCharArray();
    	for(int i=0,  j=c.length-1;i<j;){
    		if(c[i]!=c[j])
    			return false;
    		else{
    			i++;
    			j--;
    		}
    	}
        return true;
    }
    
    public List<List<String>> partition(String s) {
    	
    	for(int i=1;i<s.length();i++){
    		ArrayList<String> cur = new ArrayList<String>();
    		help(s,i,cur);
    	}
    	
    	return result;
    }
    
    public void help(String s, int len, List<String> cur){
    	if(len>s.length())
    		return;
    	String temp = s.substring(0,len);
    	String next = s.substring(len);
    	if(dict.contains(temp))
    		return;
    	if(isPalindrome(temp)){
    		ArrayList<String> newCur = new ArrayList<String>(cur);
    		newCur.add(temp);
    		if(len==s.length()){
    			result.add(newCur);
    			return;
    		}
    		for(int i=1;i<=next.length();i++){
    			help(next,i,newCur);
    		}
    		
    	}
    	else{
    		dict.add(temp);
    		return;
    	}
    }
    
    public static void main(String[] args){
    	Solution s  = new Solution();
    	List<List<String>> result = s.partition("aabbaa");
    	for(int i=0;i<result.size();i++){
    		System.out.println(result.get(i));
    	}
    }

}
