package CompareVersionNumber;

public class Solution {
	 public int compareVersion(String version1, String version2) {
	        
	        String[] v1 = version1.split("\\.");
	        String[] v2 = version2.split("\\.");
	        
	        for(int i=0;i<v1.length||i<v2.length;i++){
	            
	            String s1 = i<v1.length?v1[i]:"0";
	            String s2 = i<v2.length?v2[i]:"0";
	            
	            int len1 = s1.length();
	            int len2 = s2.length();
	            if(len1>len2)
	                s2=pad(s2,len1-len2);
	            else if(len1<len2)
	                s1=pad(s1,len2-len1);
	                
	            if(s1.compareTo(s2)==1)
	                return 1;
	            if(s1.compareTo(s2)==-1)
	                return -1;
	        }
	        
	        return 0;
	    }
	    
	    public String pad(String s, int len){
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<len;i++)
	            sb.append("0");
	        return sb.toString()+s;
	    }
	    
	    public static void main(String[] args){
	    	Solution s = new Solution();
	    	s.compareVersion("1.0", "1.2");
	    	System.out.println("0".compareTo("2"));
	    }
	    
}
