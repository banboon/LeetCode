package PalindromeNumber;
class Solution {
    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        for(int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))
            return false;
        }
        return true;
    }
}
public class isPalindrome {
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.isPalindrome(1));
	}
}
