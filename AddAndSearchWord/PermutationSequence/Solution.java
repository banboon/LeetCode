package PermutationSequence;

public class Solution {
	
	
	
	public String getPermutation(int n, int k) {
		if(n > 9) return"";
		if(n == 1) return "1";
		int [] num = new int[n+1];
		num[0] = 1;
		for(int i = 1;i<=n;i++)
			num[i] = num[i-1]*i;    // store the factor
		k = k-1;
		k = k%num[n];
		StringBuffer numStr = new StringBuffer("123456789");
		StringBuffer res = new StringBuffer();
		for(int i=n-1;i>=0;i--)
		{
			int curNum = k/num[i];
			res.append(numStr.charAt(curNum));
			numStr.deleteCharAt(curNum);
			k = k - curNum*num[i];
		}
		return res.toString();
	}


	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.getPermutation(1, 2));
	}
}
