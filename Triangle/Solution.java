package Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	int min=0;
        if(triangle==null)
        	return min;
        if(triangle.size()==1)
        	return triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
        	for(int j=0;j<triangle.get(i).size();j++){
        		if(j==0){
        			int var=triangle.get(i).get(j)+triangle.get(i-1).get(j);
        			triangle.get(i).set(j, var );
        		}
        		else if(j==triangle.get(i).size()-1){
        			int var = triangle.get(i).get(j)+triangle.get(i-1).get(j-1);
        			triangle.get(i).set(j, var);
        		}
        		else{
        			int var1=triangle.get(i-1).get(j);
        			int var2=triangle.get(i-1).get(j-1);
        			int var = triangle.get(i).get(j);
        			if(var1<var2)
        				triangle.get(i).set(j,var+var1);
        			else
        				triangle.get(i).set(j,var+var2);
        		}
        	}
        }
        List<Integer> list = triangle.get(triangle.size()-1);
        min=list.get(0);
        for(int i=1;i<list.size();i++){
        	if(min>list.get(i))
        		min=list.get(i);
        }
        return min;
    }
    
}
