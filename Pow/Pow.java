package Pow;

class Solution {
    public double pow(double x, int n) {
    	if(n==0||x==1)
    		return 1;
    	if(x==-1&&n%2==1)
    		return -1;
    	if(x==-1&&n%2==0)
    		return 1;
    	double half=pow(x,n/2);
    	if(n>0){
    		if(n%2==0)
                return half*half;
    		else
    			return x*half*half;
    	}
    	else{
    		x=1/x;
    		n=-n;
    		return pow(x,n);
    	}
    }
}
public class Pow {
	public static void main(String[] args){
	    Solution s = new Solution();
	    System.out.println(s.pow(3,3));
	}
}
