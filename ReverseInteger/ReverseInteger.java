package ReverseInteger;

class Solution {
    public int reverse(int x) {
        if(x>=0){
        	String s =String.valueOf(x);
        	StringBuffer str =new StringBuffer(s);
        	str.reverse();
        	x=Integer.parseInt(str.toString());      	
        }
        else{
        	x=-x;
        	String s =String.valueOf(x);
        	StringBuffer str =new StringBuffer(s);
        	str.reverse();
        	x=Integer.parseInt(str.toString());
        	x=-x;
        }
    	return x;
    }
}
public class ReverseInteger {
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.reverse(123));
	}

}
