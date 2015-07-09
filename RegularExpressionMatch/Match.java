package RegularExpressionMatch;
class Solution {
    public boolean isMatch(String s, String p) {
        
        if(p.length()<1)
            return s.length()<1;
            
        int i=0,j=0;
        
        if(j+1<p.length()&&p.charAt(j)=='*'){
            
            if(isMatch(s,p.substring(2))) return true;
            
            while(i<s.length()&&s.charAt(i)==p.charAt(0)){
                if(isMatch(s.substring(i+1),p.substring(2)))
                    return true;
                i++;
            }
            
            return false;
        }
        else{
            if(s.length()<1) return false;
            if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
                return isMatch(s.substring(i+1),p.substring(j+1));
            return false;
        }
    }
}
public class Match {
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.isMatch("aa", "a*"));
		
	}
}
