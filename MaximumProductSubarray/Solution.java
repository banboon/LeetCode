package MaximumProductSubarray;

import java.util.Stack;

public class Solution {
	
    public int maxProduct(int[] A) {
        if(A.length<2)
            return A[0];
        
        int max =0;
        int min = 0;
        int result = 0;
        
        for(int i =0 ; i<A.length;i++){
        	if(A[i]<0){
        		int temp = max;
        		max = min;
        		min = temp;
        	}
        	max = Math.max(max*A[i], A[i]);
        	min = Math.min(min*A[i], A[i]);
        	if(max>result)
        		result = max;
        }
        return result;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] a = {-2,0,-1,-2,3,-4};
    	System.out.print(s.maxProduct(a));
    }

}
