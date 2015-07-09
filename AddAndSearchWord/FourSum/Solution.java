package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
    public List<List<Integer>> fourSum(int[] num, int target) {
    	
    	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	Arrays.sort(num);
    	
    	if(num.length<4)
    		return result;
    	
    	for(int i=0;i<num.length-3;i++){
			if(i>0&&num[i]==num[i-1])
				continue;
//			if(num[i]>target)
//				break;
			result.addAll(threeSum(num,target-num[i],i));
    	}
        return result;
    }
	
	public List<List<Integer>> threeSum(int[] num, int target, int targetPosition) {
		ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if(num.length<3)
			return resultList;
		for(int i=targetPosition+1;i<num.length-2;i++){
			if(i>targetPosition+1&&num[i]==num[i-1])
				continue;
//			if(num[i]>target)
//				break;
			resultList.addAll(twoSum(num,target-num[i],i, num[targetPosition]));
		}
		return resultList;
	}

	public List<List<Integer>> twoSum(int[] num, int target, int targetPosition, int first) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=targetPosition+1,j=num.length-1;i<j;){
			if(num[i]+num[j]==target){
				
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList.add(first);
				tempList.add(num[targetPosition]);
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
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] a = {1,-2,-5,-4,-3,3,3,5};
		int target=-11;
		System.out.println(s.fourSum(a, target));
	}

}
