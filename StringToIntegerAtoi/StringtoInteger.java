package StringToIntegerAtoi;
import java.util.regex.Pattern;

class Solution {
	int signal=0,symbol=1;
    public int atoi(String str) {
    	StringBuffer s = new StringBuffer(str);
    	for(int i=0;i<s.length();i++){
    		if(signal==0){
        		if(s.charAt(i)>='0'&&s.charAt(i)<='9')
        			signal=1;
        		else if(s.charAt(i)=='+'){
        			signal=1;
        			s.delete(i, i+1);
        			i--;
        		}
        		else if(s.charAt(i)=='-'){
        			symbol=0;
        			signal=1;
        			s.delete(i, i+1);
        			i--;
        		}
        		else if(String.valueOf(s.charAt(i)).equals(" ")){
        			s.delete(i, i+1);
        			i--;
        		}
        		else{
        			s.delete(i, s.length());
        			i--;
        		}
    		}
    		else{
        		if(s.charAt(i)>='0'&&s.charAt(i)<='9')
        			;
        		else{
        			s.delete(i, s.length());
        		}
    		}
    	}
    	
    	str=s.toString();
    	if(str.equals(""))
    		return 0;
    	Long temp=Long.parseLong(str);
    	if(symbol!=0&&temp>2147483647)
    		return 2147483647;
    	if(symbol==0&&-temp<=-2147483648)
    		return -2147483648;
    	int result=Integer.parseInt(str);
    	if(symbol==0)
    		return -result;
    	else
    		return result;
    }
}
public class StringtoInteger {
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.atoi("  -21474 83648"));
	}
}
