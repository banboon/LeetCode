package DecodeWays;

public class Solution {
	
    public int numDecodings(String s) {
        
    	if(s==null||s.length()<1||(s.length()==1&&(s.charAt(0)-48)<1))
    		return 0;
    	
    	if(s.length()==1&&(s.charAt(0)-48)>0)
    		return 1;
    	
    	int[] count = new int[s.length()];
    	if(s.charAt(s.length()-1)-48<1){
    		count[s.length()-1]=0;
    	}
    	else
    		count[s.length()-1]=1;
    	
		String temp1 = s.substring(s.length()-2,s.length());
		int first1 = s. charAt(s.length()-2)-48;
		int second1 = s.charAt(s.length()-1)-48;
		int all1 = Integer.parseInt(temp1);
		if(all1>26&&second1==0){
			return 0;
		}
		else if(all1>26&&second1!=0){
			count[s.length()-2]=1;
		}
		else if(first1==0){
			count[s.length()-2]=0;
		}
		else{
			count[s.length()-2]=count[s.length()-1]+1;
		}
    	

    	for( int i = s.length()-3;i>=0;i--){
    		String temp = s.substring(i,i+2);
    		int first = s. charAt(i)-48;
    		int second = s.charAt(i+1)-48;
    		int all = Integer.parseInt(temp);
    		if(all>26&&second==0){
    			return 0;
    		}
    		else if(all>26&&second!=0){
    			count[i]=count[i+1];
    		}
    		else if(first==0){
    			count[i]=0;
    		}
    		else{
    			count[i]=count[i+1]+count[i+2];
    		}
    	}
    	return count[0];
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.numDecodings("611"));
    }
}
