package ShortestPalindrome;

public class Solution {
    public String shortestPalindrome(String s) {
        
        if(s.length()<2) return s;
        
        String newStr = preProcess(s);
        
        int len = newStr.length();
        int C=0, R=0, i_mirror=0;
        
        int[] p = new int[len];
        
        for(int i=0;i<len;i++){
            
            i_mirror = 2*C-i;
            
            p[i]=R>i?Math.min(R-i,p[i_mirror]):0;
            
            while(i-1-p[i]>=0&&i+1+p[i]<len&&newStr.charAt(i-1-p[i])==newStr.charAt(i+1+p[i]))
                p[i]++;
            
            if(i+p[i]>R){
                C=i;
                R=i+p[i];
            }
        }
        
        int max=0;
        for(int i=0;i<p.length;i++){
            if(i==p[i]) max=p[i];
        }
        
        String pre = s.substring(max);
        
        pre = new StringBuffer(pre).reverse().toString();
        
        return pre+s;
    }
    
    public String preProcess(String s){
        
        StringBuffer sb = new StringBuffer(s.length()*2);
        for(int i=0;i<s.length()*2;i++){
            if((i+1)%2==0){
                sb.append(s.charAt((i-1)/2));
            }
            else{
                sb.append('#');
            }
        }
        
        return sb.toString();
    }

    
    public static void main(String[] args){
    	
    	Solution s = new Solution();
    	System.out.println(s.shortestPalindrome("baaa"));
    }
}