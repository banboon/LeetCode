package MultiplyStrings;

public class Solution {
	
    public String multiply(String num1, String num2) {
    	
    	int more =0;
    	
    	char[] m1 = num1.toCharArray();
    	char[] m2 = num2.toCharArray();
    	int len1 = m1.length;
    	int len2 = m2.length;
    	
    	StringBuilder result = new StringBuilder();
    	
    	int carry =0;
    	
    	for(int i=0;i<len1+len2-1;i++){
    		int sum=carry;
    		for(int j=0;j<len1;j++){
    			if(j>i)
    				break;
    			if(i-j>len2-1)
    				continue;
    			sum+=(m1[len1-1-j]-'0')*(m2[len2-1-i+j]-'0');
    		}
    		result.insert(0, (char)(sum%10+'0'));
    		carry = sum/10;
    	}
    	if(carry!=0)
    		result.insert(0, (char)(carry+'0'));	
    	return result.toString();
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.multiply("12","12"));
	}
}
