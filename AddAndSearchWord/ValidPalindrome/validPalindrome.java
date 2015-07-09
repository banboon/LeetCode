package ValidPalindrome;


class Solution {
	boolean isValid(char ch){
		 if(ch>='A' && ch<='Z') return true;
	     if(ch>='a' && ch<='z') return true;
	     if(ch>='0' && ch<='9') return true;
	     return false;
	}
    boolean isPalindrome(String s) {
    	String str=s.toLowerCase();
    	char[] c=str.toCharArray();
    	for(int i=0,  j=c.length-1;i<j;){
    		if(!isValid(c[i])){
    			i++;
    			continue;
    		}
    		if(!isValid(c[j])){
    			j--;
    			continue;
    		}
    		if(c[i]!=c[j])
    			return false;
    		else{
    			i++;
    			j--;
    		}
    	}
        return true;
    }
}

public class validPalindrome {
	public static void main(String args[]){
		Solution s=new Solution();
		System.out.println(s.isPalindrome("aA"));
	}
}
