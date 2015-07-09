package PascalTriangleII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++){
        	if(i==0){
        		result.add(1);
        	}
        	else if(i==1){    
        		result.clear();
        		result.add(1);
        		result.add(1);
        	}
        	else{
        		ArrayList<Integer> temp = new ArrayList<Integer>(result);
        		result.clear();
        		for(int j=0;j<=i;j++){
        			if(j==0||j==i)
        				result.add(1);
        			else{
        				result.add(temp.get(j-1)+temp.get(j));
        			}
        		}
        	}
        }
        return result;
    }
}
