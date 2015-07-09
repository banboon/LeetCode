package RotateImage;
class Solution {
    public void rotate(int[][] matrix) {
    	if(matrix.length<2)
    		return;
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[i].length;j++){
        		newMatrix[j][matrix[i].length-1-i]=matrix[i][j];
        	}
        }
        matrix=newMatrix;
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[i].length;j++)
        		System.out.print(matrix[i][j]+" ");
        	System.out.println();
        }
    }
}
public class RotateImage {
	public static void main(String args[]){
		Solution s = new Solution();
		int[][] t={{1,2,3},{3,4,6},{7,8,9}};
		s.rotate(t);
	}
	
}
/*
 class Solution {  
    public void rotate(int[][] matrix) {  
        int n = matrix.length-1;  
        if(n<1) return;        
        for(int i=0; i<=n/2;i++) {  
            for(int j=i; j<n-i; j++) {  
                int temp = matrix[i][j];  
                matrix[i][j] = matrix[n-j][i];  
                matrix[n-j][i] = matrix[n-i][n-j];  
                matrix[n-i][n-j] = matrix[j][n-i];  
                matrix[j][n-i] = temp;  
            }  
        }  
    }  
} 
 */
