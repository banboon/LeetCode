package WordLadder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {  

	HashMap<String,Integer> path = new HashMap<String,Integer>();  
	 
	void bfs(String start, String end, HashSet<String> dict) {  
		Queue queue = new LinkedList<String>();  
		queue.add(start);  
		path.put(start,0);  
		String current;  
		while(!queue.isEmpty()) {  
			current = (String)queue.poll();  
			if(current==end) {  
				continue;  
			}  
			for(int i=0;i<current.length();i++) {  
				char[] strCharArr = current.toCharArray();  
				for(char ch='a';ch<='z';ch++) {  
					if(strCharArr[i]==ch) {  
						continue;  
					}  
					strCharArr[i] = ch;  
					String newWord = new String(strCharArr);  
					if(newWord.equals(end)==true||dict.contains(newWord)) {  
						
						if(path.get(newWord)==null) {  
							int depth = (int)path.get(current);  
							path.put(newWord,depth + 1);  
							queue.add(newWord);  
						}  
					}  
				}  
			}  
		}  
	}  
	 
	void dfs(String start, String end, HashSet<String> dict, ArrayList<String> pathArray,ArrayList<ArrayList<String>> result) {  
	
		if(start.equals(end)==true) {  
			pathArray.add(start);  
			Collections.reverse(pathArray);  
			result.add(pathArray);  
			return;  
		}  
		if(path.get(start)==null) {  
			return;  
		}  
		pathArray.add(start);  
		int nextDepth = (int)path.get(start) - 1;  
		for(int i=0;i<start.length();i++) {  
			char[] strCharArr = start.toCharArray();  
			for(char ch='a';ch<='z';ch++) {  
				if(strCharArr[i]==ch) {  
					continue;  
				}  
				strCharArr[i] = ch;  
				String newWord = new String(strCharArr);  

				if(path.get(newWord)!=null&&(path.get(newWord)==nextDepth)) {  
					ArrayList<String> newPathArray = new ArrayList<String>(pathArray);  
					dfs(newWord,end,dict,newPathArray,result);  
				}  
			}  
		}  
	}  

	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {  
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();  
		ArrayList<String> path1 = new ArrayList<String>();  
		if(start==null||end==null||start.length()!=end.length()) {  
			return result;  
		}  
		bfs(start, end, dict);  
		dfs(end,start, dict, path1, result);  
		return result;  
	}  


	public static void main(String[] args){
		Solution s = new Solution();
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");
		List<ArrayList<String>> result = s.findLadders(start,end,dict);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}

	}
}
