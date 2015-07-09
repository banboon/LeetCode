package NQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    List<String[]> result = new ArrayList<String[]>();
    
    public List<String[]> solveNQueens(int n) {
        
        boolean[][] matrix = new boolean[n][n];
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<n;i++){
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<n;j++){
        		if(i==j){
        			sb.append("Q");
        		}
        		else{
        			sb.append(".");
        		}
        	}
        	list.add(sb.toString());
        }
        
        String[] line = new String[n];
        
        for(int i=0;i<n;i++){
        	help(matrix,0,i,line,list);
        }
        
        return result;
    }
    
    public void help(boolean[][] matrix, int x, int y, String[] line, ArrayList<String> list){
    	
    	int n = matrix.length;
    	
    	if(x>=matrix.length){
    		String[] temp = new String[n];
    		for(int i=0;i<n;i++){
    			temp[i]=line[i];
    		}
    		result.add(temp);
    		return;
    	}
    	
    	for(int i=0;i<x;i++){
    		if(matrix[i][y])
    			return;
    		if(y-(x-i)>=0){
    			if(matrix[i][y-(x-i)])
    				return;
    		}
    		if(y+(x-i)<n){
    			if(matrix[i][y+(x-i)])
    				return;
    		}
    	}
    	
    	matrix[x][y]=true;
    	line[x] = list.get(y);
    	if(x<n-1){
	    	for(int j=0;j<n;j++){
	    		help(matrix,x+1,j, line, list);
	    	}
    	}
    	else{
    		help(matrix,x+1,0,line,list);
    	}
    	matrix[x][y]=false;
    	line[x] = null;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	List<String[]> result = s.solveNQueens(4);
    	
    	for(int i=0;i<result.size();i++){
    		String[] temp = result.get(i);
    		for(int j=0;j<temp.length;j++){
    			System.out.println(temp[j]);
    		}
    	}
    }
}
