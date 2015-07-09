package SingleNumber;
import java.util.Arrays;

class Solution2 {
    public int singleNumber(int[] A) {
    	if(A.length==1){
    		return A[0];
    	}
    	Arrays.sort(A);
    	for(int i=0;i<A.length;){
    		if(i==A.length-1)
    			return A[i];
    		if(A[i]==A[i+1]&&A[i]==A[i+2])
    			i+=3;
    		else
    			return A[i];
    	}
        return -1;
    }
}

public class singleNumber2 {
	public static void main(String args[]){
		Solution2 s = new Solution2();
		int A[] = {2,2,1,3,3,3,2,4,4,4};
		System.out.println(s.singleNumber(A));
	}

}
