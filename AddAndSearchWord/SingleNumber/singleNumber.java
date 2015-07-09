package SingleNumber;
import java.util.Arrays;

class Solution {
    public int singleNumber(int[] A) {
    	Arrays.sort(A);
    	if(A.length==1){
    		return A[0];
    	}
    	for(int i=0;i<A.length;i++){
    		if(i==0){
    			if(A[i]!=A[i+1])
    				return A[i];
    		}
    		else if(i==A.length-1){
    			if(A[i]!=A[i-1])
    				return A[i];
    		}
    		else{
    			if(A[i]!=A[i-1]&&A[i]!=A[i+1])
    				return A[i];
    		}
    	}
        return -1;
    }
}

public class singleNumber {
	public static void main(String args[]){
		Solution s = new Solution();
		int A[] = {2,1,3,2,1,4,4};
		System.out.println(s.singleNumber(A));
	}

}
