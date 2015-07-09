package RemoveDuplicatesFromSortedArray;

public class Solution {
	public int removeDuplicates(int[] A) {

		if(A==null)
			return 0;

		if(A.length<3)
			return A.length;

		int sum=1;

		int two = 0;
		
		int i=0;
		int j=0;

		for(i=0,j=0;i<A.length;i++){
			if(A[i]==A[j]){
				two++;
			}
			else{
				if(two<2){
					j++;
					sum++;
				}
				else{
					A[j+1]=A[j];
					j+=2;
					sum+=2;
				}
				two=1;
				A[j]=A[i];
			}
		}
		
		if(two>1){
			sum++;
			j++;
			A[j]=A[i-1];
		}
		
		return sum;

	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] a = {1,1,1,1,2,2,3};
		int len = s.removeDuplicates(a);
		System.out.println(len);	
		for(int i=0;i<len;i++){
			System.out.print(a[i]+" ");
		}
	}
}
