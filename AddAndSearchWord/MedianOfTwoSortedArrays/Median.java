package MedianOfTwoSortedArrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        
        int lenA = A.length;
        int lenB = B.length;
        
        boolean odd = true;
        if((lenA+lenB)%2==0) odd=false;
        
        if(odd)
            return help(A,B,0,lenA-1,0,lenB-1,(lenA+lenB)/2+1);
        else{
            double m1 = help(A,B,0,lenA-1,0,lenB-1,(lenA+lenB)/2);
            double m2 = help(A,B,0,lenA-1,0,lenB-1,(lenA+lenB)/2+1);
            return (m1+m2)/2;
        }
    }
    
    public double help(int[] A, int[] B, int startA, int endA, int startB, int endB, int k){
        
        int midA = startA+(endA-startA)/2;
        int midB = startB+(endB-startB)/2;
        
        if(startA>endA) return (double)B[startB+k-1];
        if(startB>endB) return (double)A[startA+k-1];
        if(k==1) return (double)Math.min(A[startA],B[startB]);
        
        if(A[midA]<B[midB]){
            if(k>midA-startA+1)
                return help(A,B,midA+1,endA,startB,midB,k-(midA-startA)-1);
            else
                return help(A,B,startA,endA,startB,midB-1,k);
        }
        else{
            if(k>midB-startB+1)
                return help(A,B,startA,midA,midB+1,endB,k-(midB-startB)-1);
            else
                return help(A,B,startA,midA-1,startB,endB,k);
        }
        
        
    }
}
public class Median {
	public static void main(String args[]){
		Solution s = new Solution();
		int A[]={1,1};
		int B[]={1,2};
		System.out.println(s.findMedianSortedArrays(A,B));
	}

}
