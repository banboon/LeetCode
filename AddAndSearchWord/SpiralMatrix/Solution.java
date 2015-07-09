package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(matrix==null||matrix.length<1)
            return result;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean[][] wall = new boolean[rows][cols];
        
        int direct = 0;
        
        int p=0;
        int q=0;
        
        for(int i=0;i<rows*cols;i++){
            result.add(matrix[p][q]);
            wall[p][q]=true;
            switch(direct){
                case 0: 
                	if(q+1>=cols||wall[p][q+1]==true){
                		direct++;
                		p++;
                	}
                	else{
                		q++;
                	}
                	break;
                case 1:
                	if(p+1>=rows||wall[p+1][q]==true){
                		direct++;
                		q--;
                	}
                	else{
                		p++;
                	}
                	break;
                case 2:
                	if(q-1<0||wall[p][q-1]==true){
                		direct++;
                		p--;
                	}
                	else{
                		q--;
                	}
                	break;
                case 3:
                	if(p-1<0||wall[p-1][q]==true){
                		direct=0;
                		q++;
                	}
                	else{
                		p--;
                	}
                	break;
                default: break;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[][] a = new int[1][2];
    	a[0][0]=2;
    	a[0][1]=3;
    	System.out.println(s.spiralOrder(a));
    }
}
