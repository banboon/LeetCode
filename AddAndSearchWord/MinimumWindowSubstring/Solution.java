package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {

	public String minWindow(String S, String T) {

		if(S==null||T==null)
			return "";

		HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 

		for(int i=0;i<T.length();i++){
			Character c = new Character(T.charAt(i));
			if(!map.containsKey(c)){
				map.put(c,1);
			}
			else{
				map.put(c,map.get(c)+1);
			}
		}

		LinkedBlockingQueue<Character> first = new LinkedBlockingQueue<Character>();
		LinkedBlockingQueue<Integer> firstIndex = new LinkedBlockingQueue<Integer>();

		int start=0;
		int end=S.length();
		int sum=0;

		for(int i=0;i<S.length();i++){
			char c  = S.charAt(i);
			if(map.containsKey(c)){
				
				if(map.get(c)>0)
					sum++;

				map.put(c, map.get(c)-1);
				first.add(c);
				firstIndex.add(i);
				
				while(map.get(first.peek())<0){
					char temp = first.peek();
					first.remove();
					firstIndex.remove();
					map.put(temp,map.get(temp)+1);
				}

				if(sum==T.length()){
					if(i-firstIndex.peek()<end-start){
						start = firstIndex.peek();
						end = i+1;
					}
				}
			}
		}
		
		if(sum==T.length()){
			return S.substring(start,end);
		}
		else{
			return "" ;
		}

	}
	
	public static void main(String[] args){
		
		Solution s = new Solution();
		String a = "ABCDDDE";
		String b = "ABCD";
		System.out.println(s.minWindow(a, b));
	}
}
