package ClimbingStairs;

import java.util.HashMap;

public class Solution {
	
	private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	
    public int climbStairs(int n) {	
    	
    	map.put(0, 0);
    	map.put(1, 1);
    	map.put(2, 2);
    	
    	if(n==0)
    		return 0;
    	if(n==1)
    		return 1;
    	if(n==2)
    		return 2;
    	int var1;
    	int var2;
    	if(map.containsKey(n-1))
    		var1=map.get(n-1);
    	else{
    		var1=climbStairs(n-1);
    		map.put(n-1, var1);
    	}
    	if(map.containsKey(n-2))
    		var2=map.get(n-2);
    	else{
    		var2=climbStairs(n-2);
    		map.put(n-2, var2);
    	}
    	return var1+var2;
        
    }
}
