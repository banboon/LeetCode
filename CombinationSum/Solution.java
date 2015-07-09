package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates==null||candidates.length<1)
            return result;
        
        Arrays.sort(candidates);
        if(target<candidates[0])
            return result;
            
        ArrayList<Integer> list = new ArrayList<Integer>();
            
        help(candidates, 0, target, list);
        
        return result;
    }
    
    public void help(int[] cand, int start, int target, List<Integer> list ){
        
        if(target==0){
            result.add(list);
            return;
        }
        if(target<cand[0]||start>=cand.length||target<cand[start]){
            return;
        }
        
        for(int i=start;i<cand.length;i++){
        	if(i!=start){
        		while(cand[i]==cand[i-1]){
        			i++;
        			if(i>=cand.length)
        				return;
        		}
        	}
        	ArrayList<Integer> tempList = new ArrayList<Integer>();
            tempList.addAll(list);
        	tempList.add(cand[i]);
            help(cand, i+1 , target-cand[i], tempList);
        }
        
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] a={2,2,2};
    	int target = 2;
    	System.out.println(s.combinationSum(a, target));
    }
}
