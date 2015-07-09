package PlusOne;

class Solution {
    public int[] plusOne(int[] digits) {
    	if(digits.length==0)
    		return digits;
    	if(allNine(digits)){
    		int[] result = new int[digits.length+1];
    		result[0]=1;
    		return result;
    	}
    	int i=digits.length-1;
    	plusDigit(digits, i);
    	return digits;
    }
    public void plusDigit(int[] num, int i){
    	if(num[i]==9&&i!=0){
    			num[i]=0;
    			plusDigit(num,i-1);
    	}
    	else
    		num[i]=num[i]+1;
    }
    boolean allNine(int[] num){
    	for(int i=0;i<num.length;i++){
    		if(num[i]!=9)
    			return false;
    	}
    	return true;
    }
}

public class PlusOne {
	public static void main(String[] args){
		Solution s = new Solution();
		int t[]={9,9,9,9,9};
		int x[]=s.plusOne(t);
		for(int i=0;i<x.length;i++){
			System.out.print(x[i]);
		}
	}
}
