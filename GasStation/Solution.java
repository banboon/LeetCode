package GasStation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int len = gas.length;
    	int remain=0;
    	int i=0;
    	int j=0;
    	int complete=1;
    	for(i=0;i<len;){
    		remain=0;
    		for( j=0;j<len;j++){
    			complete=1;
    			int position;
    			if(i+j>=len){
    				position=i+j-len;
    			}
    			else{
    				position=i+j;
    			}
    			remain=remain+gas[position]-cost[position];
    			if(remain<0){
    				i=i+j+1;
    				complete=0;
    				break;
    			}
    		}
    		if(complete==1)
    			return i;
    	}
        return -1;
    }
    
    public static void main(String[] args){
    	int[] gas={1,2};
    	int[] cost={2,1};
    	Solution s = new Solution();
    	System.out.println(s.canCompleteCircuit(gas, cost));
    }
}
