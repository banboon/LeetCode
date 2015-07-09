package WordBreak;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public boolean wordBreakHelper(String s, Set<String> dict, Set<String>unmatch){
		if(s.length()<1)
			return true;
		for(int i=1;i<=s.length();i++){
			String prefix = s.substring(0,i);
			if(dict.contains(prefix)){
				String suffix = s.substring(i);
				if(unmatch.contains(suffix))
					continue;
				else{
					boolean flag = wordBreakHelper(suffix,dict,unmatch);
					if(flag)
						return true;
					else{
						unmatch.add(suffix);
					}
				}
			}
		}
		return false;
	}
	
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length()<1)
        	return true;
        HashSet<String> unmatch = new HashSet<String>();
        return wordBreakHelper(s,dict,unmatch);
    }
    
    public static void main(String[] args){
    	String a = "ab";
    	HashSet<String> dict =new HashSet<String>();
    	dict.add("a");
    	dict.add("b");
    	Solution s = new Solution();
    	System.out.println(s.wordBreak(a, dict));
    }
}

