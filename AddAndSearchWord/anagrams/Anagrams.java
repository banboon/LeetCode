package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public ArrayList<String> anagrams(String[] strs) {
    	ArrayList<String> strList = new ArrayList<String>();
    	Map<String,Integer> map = new HashMap<String,Integer>();
    	if(strs.length<1)
    		return strList;
    	for(int i=0;i<strs.length;i++){
    		char[] temp =strs[i].toCharArray();
    		Arrays.sort(temp);
    		if(!map.containsKey(String.valueOf(temp)))
    			map.put(String.valueOf(temp), i);
    		else{
    			if(!strList.contains(strs[map.get(String.valueOf(temp))]))
    			        strList.add(strs[map.get(String.valueOf(temp))]);
    			strList.add(strs[i]);
    		}
    	}
    	return strList;
    }
}
public class Anagrams {
	public static void main(String[] args){
		Solution s = new Solution();
		String t[] ={"eat","ate","sada","da","ad","tea"};
		System.out.println(s.anagrams(t));
	}
}
