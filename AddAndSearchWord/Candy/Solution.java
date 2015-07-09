package Candy;

public class Solution {
	
    public int candy(int[] ratings) {
    	int N = ratings.length;
    	int give =1;
    	int[] candy = new int[N];
    	int result = 0;
    	
    	for(int i=0;i<N;i++){
    	    candy[i]=1;
    	}
    	
    	for(int i=0;i<N-1;i++){
    		if(ratings[i+1]>ratings[i]){
    			candy[i+1]=candy[i]+1;
    		}
    	}
    	
    	for(int i=N-1;i>0;i--){
    		if(ratings[i-1]>ratings[i]){
    			if(candy[i-1]<=candy[i])
    			    candy[i-1]=candy[i]+1;
    		}
    	}
    	
    	for(int i=0;i<N;i++){
    		result+=candy[i];
    	}
    	for(int i=0;i<N;i++)
    		System.out.print(candy[i]);
    	System.out.println();
        return result;
    }
    
    public static void main(String[] args){
    	int[] ratings={1,3,4,3,2,1};
    	Solution s = new Solution();
    	System.out.println(s.candy(ratings));
    }
}
