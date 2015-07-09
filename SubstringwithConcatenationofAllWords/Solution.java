package SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	
    public List<Integer> findSubstring(String S, String[] L) {
        
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	List<Integer> result = new ArrayList<Integer>();
    	
    	if(L == null||L.length<1)
    		return result;
    	
    	int len = L[0].length();
    	int num = L.length;
    	int totalLen = len*num;
    	
    	for(int i=0;i<num;i++){
    		if(map.containsKey(L[i])){
    			map.put(L[i], map.get(L[i])+1);
    		}
    		else{
    			map.put(L[i],1);
    		}
    	}
    	
    	for(int i=0; i<=S.length()-totalLen;i++ ){
    		
    		HashMap<String, Integer> temp = new HashMap<String, Integer>();
    		String all = S.substring(i,i+totalLen);
    		int j=0;
    		for(j=0;j<num;j++){
    			String s = all.substring(j*len,j*len+len);
    			if(!map.containsKey(s))
    				break;
    			else{
    				if(!temp.containsKey(s)){
    					temp.put(s, 1);
    				}
    				else{
    					if(temp.get(s)+1>map.get(s))
    						break;
    					else{
    						temp.put(s, temp.get(s)+1);
    					}
    				}
    			}
    		}
    		if(j>=num){
    			result.add(i);
    		}

    	}
    	return result;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	String str = "barfoothefoobarman";
    	String[] l = {"foo", "bar"};
    	System.out.print(s.findSubstring(str, l));
    }
}
