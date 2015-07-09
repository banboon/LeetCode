package SearchforaRange;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] A, int target) {
    	int begin;
    	int last;
        int[] find = {-1,-1};
        begin=last=Arrays.binarySearch(A, target);
        if(begin<0||begin>A.length-1)
        	return find;
        while(begin>=0&&A[begin]==target)
        	begin--;
        while(last<=A.length-1&&A[last]==target)
        	last++;
        find[0]=begin+1;
        find[1]=last-1;
        return find;
    }
    
    public static void main(String[] args){
    	Solution s  = new Solution();
    	int[] A={2,2};
    	int target=3;
    	int[] result = s.searchRange(A, target);
    	System.out.println(result[0]);
    	System.out.println(result[1]);
    }
}
