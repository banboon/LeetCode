package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	ArrayList<ArrayList<Integer>> resultList=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> tempList = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	if(num.length==0)
    		return null;
    	ArrayList<Integer> number = new ArrayList<Integer>();
        for(int i=0;i<num.length;i++){
        	number.add(num[i]);
        }
        solute(number);
    	return resultList;
    }
    public void solute(ArrayList<Integer> number){
    	ArrayList<Integer> count = new ArrayList<Integer>();
    	for(int i=0;i<number.size();i++){
    		if(count.contains(number.get(i)))
    			continue;
    		else
    			count.add(number.get(i));
    		tempList.add(number.get(i));
    		if(number.size()==1){
    			   resultList.add(new ArrayList(tempList));
    		}
    		else{
    			int x=number.get(i);
        		number.remove(i);
        		solute(number);
        		number.add(i,x);
    		}
    		tempList.remove(tempList.size()-1);
    	}
    }
}
public class Permutations {
	
	public static void main(String[] args){
		int t[]={1,1,3,3};
		Solution s = new Solution();
		System.out.println(s.permuteUnique(t));
	}
}
