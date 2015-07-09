package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

	private HashMap<Character, Character[]> map = new HashMap<Character,Character[]>(){
		{
			Character[] two = {'a','b','c'};
			Character[] three = {'d','e','f'};
			Character[] four = {'g','h','i'};
			Character[] five = {'j','k','l'};
			Character[] six = {'m','n','o'};
			Character[] seven = {'p','q','r','s'};
			Character[] eight = {'t','u','v'};
			Character[] nine = {'w','x','y','z'};

			put('2', two);
			put('3', three);
			put('4', four);
			put('5', five);
			put('6', six);
			put('7', seven);
			put('8', eight);
			put('9', nine);
		}
	};

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();

		if(digits==null||digits.length()<1){
			result.add("");
			return result;
		}

		for(int i=0;i<digits.length();i++){
			if(result.size()<1){
				Character[] temp = map.get(digits.charAt(i));
				for(int j=0;j<temp.length;j++){
					result.add(temp[j].toString());
				}
				continue;
			}
			Character[] temp = map.get(digits.charAt(i));
			String[] origin = new String[result.size()];
			result.toArray(origin);
			result.clear();
			for(int j=0;j<origin.length;j++){
				String temp1 = origin[j];
				for(int k=0;k<temp.length;k++){
					String temp2 = temp[k].toString();
					result.add(temp1+temp2);
				}
			}
		}
		return result;
	}

	public static void main(String[] args){
		Solution s = new Solution();
		String input = "23";
		System.out.println(s.letterCombinations(input));
	}
}
