package PascalTriangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        if(numRows<1)
        	return result;
        for(int i=1;i<=numRows;i++){
        	if(i==1){
        		List<Integer> temp = new ArrayList<Integer>();
        		temp.add(1);
        		result.add(temp);
        	}
        	else if(i==2){
        		ArrayList<Integer> temp = new ArrayList<Integer>();
        		temp.add(1);
        		temp.add(1);
        		result.add(temp);
        		stack.push(temp);
        	}
        	else{
        		ArrayList<Integer> temp = new ArrayList<Integer>();
        		for(int j=1;j<=i;j++){
        			if(j==1||j==i)
        				temp.add(1);
        			else{
        				ArrayList<Integer> tempList = stack.pop();
        				temp.add(tempList.get(j-2)+tempList.get(j-1));
        				stack.push(tempList);
        			}
        		}
        		result.add(temp);
        	    stack.pop();
        	    stack.push(temp);
        	}
        }
        return result;
    }
}