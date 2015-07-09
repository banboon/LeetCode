package GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        if(n==0)
        	return new ArrayList<Integer>(){
        	{
        		add(0);
        	}
        };
        int num = (int) Math.pow(2, n);
        List<Integer> result = new ArrayList<Integer>();
        int[] temp = new int[n];
        for(int i=0;i<num;i+=2){
        	result.add(transfer(temp));
        	temp[0]=1-temp[0];
        	result.add(transfer(temp));
        	int j=0;
        	for(j=0;j<n;j++){
        		if(temp[j]==1)
        			break;
        	}
        	if(j<n-1)
        	    temp[j+1]=1-temp[j+1];
        }
        return result;
    }
    
    public int transfer(int[] temp){
    	int sum=0;
    	for(int i=0;i<temp.length;i++){
    		if(temp[i]==1){
    			sum+=Math.pow(2, i);
    		}
    	}
    	return sum;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.grayCode(0));
    	
    }
    
}
