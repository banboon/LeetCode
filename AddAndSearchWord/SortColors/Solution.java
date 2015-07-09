package SortColors;

import java.util.ArrayList;

public class Solution {
    public void sortColors(int[] A) {
    	ArrayList<Integer> color = new ArrayList<Integer>();
        ArrayList<Integer> red = new ArrayList<Integer>();
        ArrayList<Integer> white = new ArrayList<Integer>();
        ArrayList<Integer> blue = new ArrayList<Integer>();
        for(int i=0;i<A.length;i++){
        	if(A[i]==0)
        		red.add(0);
        	else if(A[i]==1)
        		white.add(1);
        	else
        		blue.add(2);
        }
        color.addAll(red);
        color.addAll(white);
        color.addAll(blue);
        for(int i=0;i<A.length;i++){
        	A[i]=color.get(i);
        }
    }
}