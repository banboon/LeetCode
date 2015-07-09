package MaxiumSubarray;

public class Solution {
    public int maxSubArray(int[] A) {
        
        if(A.length<1)
            return 0;
        
        int max = A[0];
        
        int[][] matrix = new int[A.length][A.length];
        
        for(int col = 0; col<A.length;col++){
            for(int row=0;row<=col;row++){
                if(row==0){
                    matrix[row][col] = A[col];
                    if(matrix[row][col]>max){
                        max=matrix[row][col];
                    }
                }
                else{
                    int temp = matrix[row-1][col-1]+matrix[0][col];
                    matrix[row][col]=temp;
                    if(temp>max){
                        max=temp;
                    }
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] array ={-2,1,-3,4,-1,2,1,-5,4};
    	System.out.print(s.maxSubArray(array));
    }
}
