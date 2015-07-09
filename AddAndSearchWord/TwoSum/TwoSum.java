package TwoSum;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
    	Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<numbers.length;i++){
    		if(!map.containsKey(numbers[i])){
    			map.put(numbers[i], i);
    		}
    		if(map.containsKey(target-numbers[i])){
    			int temp=map.get(target-numbers[i]);
    			if(i==temp)
    				continue;
    	    	result[0]=i+1;
    	    	result[1]=temp+1;
    		}
    	}
    	if(result[0]>result[1]){
    		int temp=result[0];
    		result[0]=result[1];
    		result[1]=temp;
    	}
    	return result;
    }
}

public class TwoSum {
	
	public static void main(String args[]){
		Solution s = new Solution();
		int numbers[]={3,2,4,3};
		int target=6;
		int result[]=s.twoSum(numbers, target);
		System.out.println("index1:"+result[0]+",index2:"+result[1]);
		
	}

}
