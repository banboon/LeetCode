package UniqueBinarySearchTrees;

public class Solution {
    public int numTrees(int n) {
    	if(n<3) return n;
        int[] result = new int[n+1];
        result[0]=1;
        result[1]=1;
        result[2]=2;
        for(int i=3;i<n+1;i++){
        	for(int j=1;j<=i;j++){
        		result[i]+=result[j-1]*result[i-j];
        	}
        }
        return result[n];
    }
}
