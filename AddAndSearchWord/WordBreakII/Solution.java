package WordBreakII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
    	
    	HashSet<String> unmatch = new HashSet<String>();
    	
    	return wordBreakHelper(s,dict,unmatch);
        
    }
    
	public List<String> wordBreakHelper(String s, Set<String> dict, Set<String>unmatch){
		ArrayList<String> result = new ArrayList<String>();
		if(s.length()<1)
			return result;
		for(int i=1;i<=s.length();i++){
			String prefix = s.substring(0,i);
			if(dict.contains(prefix)){
				String suffix = s.substring(i);
				if(suffix.equals("")){
					result.add(prefix);
					return result;
				}
				if(unmatch.contains(suffix))
					continue;
				else{
					List<String> flag = wordBreakHelper(suffix,dict,unmatch);
					if(flag.size()==0)
						unmatch.add(suffix);
					else{
						for(int j=0;j<flag.size();j++){
							result.add(prefix+" "+flag.get(j));
						}
					}
				}
			}
		}
		return result;
	}
}
