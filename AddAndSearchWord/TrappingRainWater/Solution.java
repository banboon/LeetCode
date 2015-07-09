package TrappingRainWater;

public class Solution {
	
	public int trap(int[] A) {
		
	    if(A==null||A.length<2)
	        return 0;
		
		int result = 0;
		
		int maxIndex = 0;
		for(int i=0;i<A.length;i++){
			if(A[i]>A[maxIndex])
				maxIndex=i;
		}
		int max = A[maxIndex];
		
		int maxTemp = A[0];
		for(int i=1;i<maxIndex;i++){
			if(A[i]>=maxTemp){
				maxTemp=A[i];
			}
			else{
				result+=(maxTemp-A[i]);
			}		
		}
		maxTemp=A[A.length-1];
		for(int i=A.length-2;i>maxIndex;i--){
			if(A[i]>=maxTemp){
				maxTemp=A[i];
			}
			else{
				result+=(maxTemp-A[i]);
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] a ={5,4,1,2};
		System.out.println(s.trap(a));
	}
}
