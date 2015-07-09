package DivideTwoIntegers;

import java.util.ArrayList;

public class Solution {
	
	public int divide(int dividend, int divisor) {
		
		if(dividend==0)
			return 0;
		
		boolean minus = false;
		if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)){
			minus = true;
		}
		
		if(dividend>0)
			dividend = -dividend;
		
		if(divisor>0)
			divisor = -divisor;
		
		int result = help(dividend,divisor);
		
		if(minus){
			return -result;
		}
		else{
			return result;
		}
	}
	
	public int help(int up, int down){
		
		int result = 0;
		int times=1;
		
		int start = down;
		
		while(up<=down){
			result+=times;
			up-=down;
			if(down<Integer.MIN_VALUE-down)
				break;
			down+=down;
			times+=times;
		}
		
		if(up>start){
			return result;
		}
		else if(up==start){
			return result+1;
		}
		else{
			return result+help(up,start);
		}
	}
	
	
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.divide(-2147483648, 2));
	}
}
