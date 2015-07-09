package ThreeSum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if(num.length<3)
			return resultList;
		Arrays.sort(num);
		for(int i=0;i<num.length-2;i++){
			if(i>0&&num[i]==num[i-1])
				continue;
			if(num[i]>0)
				break;
			resultList.addAll(twoSum(num,-num[i],i));
		}
		return resultList;
	}

	public List<List<Integer>> twoSum(int[] num, int target, int targetPosition) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=targetPosition+1,j=num.length-1;i<j;){
			if(num[i]+num[j]==target){
				
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList.add(-target);
				tempList.add(num[i]);
				tempList.add(num[j]);
				result.add(tempList);
				i++;
				j--;
                while (i < j && num[i] == num[i - 1]) {  
                    i++;  
                }  
                while (i < j && num[j] == num[j + 1]) {  
                    j--;  
                } 
			}
			else if(num[i]+num[j]<target)
				i++;
			else
				j--;
		}
		return result;

	}
}

public class Sum3 {
	public static void main(String[] args){
		Solution s = new Solution();
		int t[]={11,11,-1,0,1,11,11};
		System.out.println(s.threeSum(t));
	}
}
